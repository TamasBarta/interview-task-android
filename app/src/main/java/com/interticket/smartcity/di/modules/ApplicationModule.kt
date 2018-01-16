package com.interticket.smartcity.di.modules

import android.content.Context
import com.interticket.smartcity.Application
import com.interticket.smartcity.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ApplicationModule(private val application: Application) {

    @Provides @Singleton @ApplicationContext
    fun provideApplicationContext(): Context = application
}
