package es.cristianlm.domain.service

import es.cristianlm.domain.repository.TranslationRepository
import es.cristianlm.model.Language
import es.cristianlm.model.Translation
import javax.inject.Inject

class TranslationService @Inject constructor(
    private val translationRepository: TranslationRepository
) {

    fun getTranslations(prefix: String, lang: Language): List<Translation> =
        translationRepository.getTranslations(prefix, lang)

    fun getTranslation(key: String, lang: Language? = null): Translation? =
        if (lang != null) {
            translationRepository.getTranslation(key, lang)
        } else {
            translationRepository.getTranslation(key)
        }
}
