package com.interticket.smartcity

import com.interticket.smartcity.di.components.ApplicationComponent
import com.interticket.smartcity.di.components.DaggerApplicationComponent
import com.interticket.smartcity.di.modules.ApplicationModule

class Application : android.app.Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
    }
}
