package es.cristianlm

import dagger.Component
import dagger.Module
import dagger.Provides
import es.cristianlm.app.module.DataModule
import es.cristianlm.route.AppRoute
import es.cristianlm.route.AssetRoutes
import es.cristianlm.route.HomeRoutes
import es.cristianlm.route.SessionRoutes
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
        assetRoutes: AssetRoutes,
        sessionRoutes: SessionRoutes,
        homeRoutes: HomeRoutes,
    ): List<AppRoute> = listOf(
        assetRoutes,
        sessionRoutes,
        homeRoutes
    )
}
