package ninja.shuza.androidMvvm.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ninja.shuza.androidMvvm.ui.base.MvvmApp
import ninja.shuza.androidMvvm.di.builder.ActivityBuilder
import ninja.shuza.androidMvvm.di.module.AppModule
import ninja.shuza.androidMvvm.di.module.NetworkModule
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

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, NetworkModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(app: MvvmApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}