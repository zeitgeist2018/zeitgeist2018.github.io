package es.cristianlm

import dagger.Component
import dagger.Module
import dagger.Provides
import es.cristianlm.app.module.DataModule
import es.cristianlm.route.AppRoute
import es.cristianlm.route.HomeRoutes
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppConfigModule::class,
        DataModule::class
    ]
)
interface AppContainer {
    fun getApp(): App
}

@Module
open class AppConfigModule {

    @Provides
    @Singleton
    fun routes(
        homeRoutes: HomeRoutes
    ): List<AppRoute> = listOf(
        homeRoutes
    )
}
