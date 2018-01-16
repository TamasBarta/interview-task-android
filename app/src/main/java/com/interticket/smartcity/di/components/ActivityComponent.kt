package com.interticket.smartcity.di.components

import com.interticket.smartcity.di.modules.ActivityModule
import com.interticket.smartcity.presentation.MainPresenter
import com.interticket.smartcity.ui.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
    fun mainPresenter(): MainPresenter
}
