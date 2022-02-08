package es.cristianlm.model

enum class Language(val code: String, val displayName: String) {
    ENGLISH("en", "English");

    companion object {
        operator fun get(code: String): Language =
            values().find { it.code == code }!!
    }
}

data class Translation(
    val key: String,
    val values: Map<Language, String>
)
