package es.cristianlm

object Boot {
    @JvmStatic
    fun main(args: Array<String>) {
        val app = DaggerAppContainer
            .builder()
            .build()
            .getApp()
        Runtime.getRuntime().addShutdownHook(Thread({ app.stop() }, "shutdown-hook"))
        app.start(true)
    }
}
