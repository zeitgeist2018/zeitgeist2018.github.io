package es.cristianlm

import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppConfigModule::class
    ]
)
interface AppContainer {
    fun getApp(): App
}

@Module
open class AppConfigModule {

}
