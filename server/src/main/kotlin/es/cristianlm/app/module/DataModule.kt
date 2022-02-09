package es.cristianlm.app.module

import dagger.Module
import dagger.Provides
import es.cristianlm.domain.repository.TranslationRepository
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun getTranslationRepository(
    ): TranslationRepository = TranslationRepository()
}
