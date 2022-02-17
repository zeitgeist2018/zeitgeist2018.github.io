package es.cristianlm.domain.service

import es.cristianlm.domain.repository.TranslationRepository
import es.cristianlm.model.Language
import es.cristianlm.model.Translation
import javax.inject.Inject

enum class PageSection {
    NAVBAR
}

class TranslationService @Inject constructor(
    private val translationRepository: TranslationRepository
) {

    fun getTranslationsAsMap(prefix: String, lang: Language): Map<String, String> =
        translationRepository.getTranslations(prefix, lang)
            .associate { it.key to it.values.values.first() }

    fun getTranslations(section: PageSection, lang: Language): Map<String, String> =
        when (section) {
            PageSection.NAVBAR -> getTranslationsAsMap("navbar", lang)
        }

    fun getTranslations(prefix: String, lang: Language): List<Translation> =
        translationRepository.getTranslations(prefix, lang)

    fun getTranslation(key: String, lang: Language? = null): Translation? =
        if (lang != null) {
            translationRepository.getTranslation(key, lang)
        } else {
            translationRepository.getTranslation(key)
        }
}
