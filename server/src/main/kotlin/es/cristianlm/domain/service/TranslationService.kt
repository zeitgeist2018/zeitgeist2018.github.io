package es.cristianlm.domain.service

import es.cristianlm.domain.repository.TranslationRepository
import es.cristianlm.model.Language
import es.cristianlm.model.Translation
import javax.inject.Inject

class TranslationService @Inject constructor(
    private val translationRepository: TranslationRepository
) {

    fun getTranslation(key: String, language: Language? = null): Translation? =
        if (language != null) {
            translationRepository.getTranslation(key, language)
        } else {
            translationRepository.getTranslation(key)
        }
}
