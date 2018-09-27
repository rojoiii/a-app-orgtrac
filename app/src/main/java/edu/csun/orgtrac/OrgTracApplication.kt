package edu.csun.orgtrac

import android.app.Application
import edu.csun.orgtrac.injection.AppComponent
import edu.csun.orgtrac.injection.AppModule
import edu.csun.orgtrac.injection.DaggerAppComponent
import timber.log.Timber

class OrgTracApplication : Application(){
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}