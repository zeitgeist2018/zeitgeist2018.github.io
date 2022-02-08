package es.cristianlm.model

data class Language(
    val code: String,
    val displayName: String
)

data class Translation(
    val key: String,
    val values: Map<Language, String>
)
