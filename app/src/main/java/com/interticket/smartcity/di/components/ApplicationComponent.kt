package com.interticket.smartcity.di.components

import com.interticket.smartcity.Application
import com.interticket.smartcity.di.modules.ActivityModule
import com.interticket.smartcity.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: Application)

    fun activityComponent(activityModule: ActivityModule): ActivityComponent
}
