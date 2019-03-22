package com.wada811.databindingktx

import android.app.Application
import android.content.Context
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher


class App : Application() {
    companion object {
        fun getRefWatcher(context: Context): RefWatcher {
            val application = context.applicationContext as App
            return application.refWatcher
        }
    }

    private lateinit var refWatcher: RefWatcher

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        refWatcher = LeakCanary.install(this)
    }
}