package edu.csun.orgtrac.injection

import dagger.Component
import edu.csun.orgtrac.activity.LandingActivity
import edu.csun.orgtrac.activity.LoadingActivity
import edu.csun.orgtrac.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(target: LoadingActivity)
    fun inject(target: LandingActivity)
    fun inject(target: MainActivity)
}