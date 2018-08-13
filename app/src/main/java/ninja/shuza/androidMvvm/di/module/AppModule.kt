package ninja.shuza.androidMvvm.di.module

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import dagger.Module
import dagger.Provides
import ninja.shuza.androidMvvm.ui.base.ViewModelProviderFactory
import ninja.shuza.androidMvvm.ui.login.LoginViewModel
import javax.inject.Singleton

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  14-Aug-2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: Application): Context = app

    @Provides
    fun provideViewModelFactory(loginViewModel: LoginViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(loginViewModel)
    }
}