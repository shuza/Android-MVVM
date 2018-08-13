package ninja.shuza.androidMvvm.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ninja.shuza.androidMvvm.networkIO.ApiService
import java.lang.ref.WeakReference

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  13-Aug-2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

open class BaseViewModel<N>(val apiService: ApiService) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val compositeDisposable = CompositeDisposable()
    var mNavigator: WeakReference<N>? = null

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }
}