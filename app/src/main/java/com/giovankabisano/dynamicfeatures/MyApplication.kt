package com.giovankabisano.dynamicfeatures

import com.giovankabisano.dynamicfeatures.infrastructure.di.sharedPreferenceModule
import com.google.android.play.core.splitcompat.SplitCompatApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.PrintLogger

class MyApplication : SplitCompatApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            logger(logger = PrintLogger())
            androidContext(this@MyApplication)
            modules(
                listOf(
                    sharedPreferenceModule
                )
            )
        }
    }
}
