package es.cristianlm.domain.repository

import es.cristianlm.model.Language
import es.cristianlm.model.Translation
import kotlinx.serialization.json.*
import java.io.File

class TranslationRepository {

    private val folder = "/translations"

    fun getAllTranslationKeys(): Set<String> =
        availableLanguages()
            .map { javaClass.getResource(getFilePath(it))?.readText()!! }
            .map { parseToJson(it) }
            .map { extractKeys(it) }
            .reduce { acc, set -> acc.plus(set) }

    fun getTranslation(key: String): Translation? {
        val values = availableLanguages()
            .map { getTranslation(key, it) }
            .mapNotNull { it?.values }
            .reduce { acc, map -> acc.plus(map) }

        return if (values.isNotEmpty()) Translation(key, values) else null
    }

    fun getTranslation(key: String, lang: Language): Translation? =
        javaClass.getResource(getFilePath(lang))
            ?.readText()
            ?.let {
                val json = parseToJson(it).jsonObject
                val keyParts = key.split(".")
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


    private fun extractKeys(jsonElement: JsonElement, key: String? = null): Set<String> =
        when (jsonElement) {
            is JsonPrimitive -> setOf(key ?: "")
            is JsonObject -> {
                val prefix = key?.let { "$it." }.orEmpty()
                jsonElement.jsonObject.keys.map { nextKey ->
                    extractKeys(
                        jsonElement[nextKey]!!,
                        "$prefix$nextKey"
                    )
                }.reduce { acc, set -> acc.plus(set) }
            }
            else -> setOf()
        }

    private fun availableLanguages(): Set<Language> =
        javaClass.getResource(folder)?.file
            ?.let { file ->
                File(file)
                    .walk()
                    .filter { it.isFile }
                    .filter { it.name.endsWith(".json") }
                    .map { it.name.removeSuffix(".json") }
                    .map { Language[it] }
                    .toSet()
            } ?: setOf()

    private fun parseToJson(json: String): JsonElement =
        Json.parseToJsonElement(json)

    private fun getFilePath(lang: Language) = "$folder/${lang.code}.json"
}
