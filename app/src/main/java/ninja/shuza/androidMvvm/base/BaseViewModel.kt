package ninja.shuza.androidMvvm.base

import android.arch.lifecycle.ViewModel
import ninja.shuza.androidMvvm.injection.component.DaggerViewModelInjector
import ninja.shuza.androidMvvm.injection.component.ViewModelInjector
import ninja.shuza.androidMvvm.injection.module.NetworkModule
import ninja.shuza.androidMvvm.ui.post.PostListViewModel

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  30-Jul-2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     *  Inject required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }

}