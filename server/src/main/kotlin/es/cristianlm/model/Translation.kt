package es.cristianlm.model

enum class Language(val code: String, val displayName: String) {
    ENGLISH("en", "English"),
    SPANISH("es", "Español");

    companion object {
        operator fun get(code: String): Language =
            values().find { it.code == code }!!

        val default = ENGLISH
        fun isValid(code: String): Boolean = values().map { it.code }.contains(code)
    }
}

data class Translation(
    val key: String,
    val values: Map<Language, String>
) {
    operator fun get(language: Language): String =
        values[language]!!
}
