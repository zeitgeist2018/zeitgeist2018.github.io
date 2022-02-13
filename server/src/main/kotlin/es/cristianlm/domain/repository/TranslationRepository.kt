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

    fun getTranslations(prefix: String, lang: Language): List<Translation> =
        extractKeys(getJson(lang), prefix)
            .map { key -> getTranslation(key, lang) }


    fun getTranslation(key: String): Translation? {
        val values = availableLanguages()
            .map { getTranslation(key, it) }
            .map { it.values }
            .reduce { acc, map -> acc.plus(map) }

        return if (values.isNotEmpty()) Translation(key, values) else null
    }

    fun getTranslation(key: String, lang: Language): Translation {
        val value = extractJson(getJson(lang), key).jsonPrimitive.content
        return Translation(key, mapOf(lang to value))
    }

    private fun extractJson(jsonElement: JsonElement, key: String): JsonElement {
        val keyParts = key.split(".")
        val currentKey = keyParts.first()
        val newKey = keyParts
            .filterIndexed { i, _ -> i > 0 }
            .joinToString(".")
        val childElement = jsonElement.jsonObject[currentKey]!!
        if (keyParts.size > 1) {
            return extractJson(childElement, newKey)
        }
        return childElement
    }

    private fun extractKeys(jsonElement: JsonElement, key: String? = null): Set<String> =
        when (jsonElement) {
            is JsonPrimitive -> setOf(key ?: "")
            is JsonObject -> {
                val prefix = key?.let { "$it." }.orEmpty()
                val element = key?.let { jsonElement.jsonObject[it] } ?: jsonElement
                element.jsonObject.jsonObject.keys.filter { it != key }.map { nextKey ->
                    extractKeys(
                        element.jsonObject[nextKey]!!,
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

    private fun getJson(lang: Language): JsonElement =
        parseToJson(javaClass.getResource(getFilePath(lang))?.readText()!!)

    private fun parseToJson(json: String): JsonElement =
        Json.parseToJsonElement(json)

    private fun getFilePath(lang: Language) = "$folder/${lang.code}.json"
}
