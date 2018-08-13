package ninja.shuza.androidMvvm.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ninja.shuza.androidMvvm.ui.login.LoginActivity

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
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity
}