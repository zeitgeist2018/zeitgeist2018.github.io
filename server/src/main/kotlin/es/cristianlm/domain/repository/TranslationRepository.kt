package es.cristianlm.domain.repository

import es.cristianlm.model.Language
import es.cristianlm.model.Translation
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.io.File

class TranslationRepository() {

    private val folder = "translations"

    fun getTranslation(key: String): Translation? {
        val values = availableLanguages()
            .map { getTranslation(key, it) }
            .mapNotNull { it?.values }
            .reduce { acc, map ->
                acc.toMutableMap().putAll(map)
                acc
            }

        return Translation(key, values)
    }

    fun getTranslation(key: String, lang: Language): Translation? =
        javaClass.getResource(getPath(lang))
            ?.readText()
            ?.let {
                val json = parse(it).jsonObject
                val keyParts = key.split(",")
                var currentElement: JsonElement? = null
                keyParts.forEach { part ->
                    currentElement =
                        if (currentElement == null) {
                            json[part]
                        } else if (keyParts.last() == part) {
                            currentElement?.jsonObject?.get(part)?.jsonPrimitive
                        } else {
                            currentElement?.jsonObject?.get(part)?.jsonObject
                        }
                }
                Translation(key, mapOf(lang to currentElement!!.jsonPrimitive.content))
            }

    private fun availableLanguages(): Set<Language> =
        javaClass.getResource(folder)?.file
            ?.let {
                File(it)
                    .walk()
                    .filter { it.isFile }
                    .filter { it.name.endsWith(".json") }
                    .map { it.name.removeSuffix(".json") }
                    .map { Language[it] }
                    .toSet()
            } ?: setOf()

    private fun parse(json: String): JsonElement =
        Json.parseToJsonElement(json)

    private fun getPath(lang: Language) = "$folder/${lang.code}.json"
}
