package ninja.shuza.androidMvvm.ui.login

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import ninja.shuza.androidMvvm.networkIO.ApiService
import ninja.shuza.androidMvvm.networkIO.createLoginRequestBody
import ninja.shuza.androidMvvm.networkIO.deserializer.LoginResponse
import ninja.shuza.androidMvvm.ui.base.BaseViewModel
import javax.inject.Inject

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

class LoginViewModel @Inject constructor(apiService: ApiService) : BaseViewModel<LoginNavigator>(apiService) {

    fun isValidUsernameAndPassword(username: String, password: String): Boolean {
        return username.isNotEmpty() and password.isNotEmpty()
    }

    fun login(username: String, password: String) {
        isLoading.postValue(true)

        val body = createLoginRequestBody(username, password)

        val observer = object : DisposableObserver<LoginResponse>() {
            override fun onComplete() {}

            override fun onNext(t: LoginResponse) {
                isLoading.postValue(false)
                mNavigator?.get()?.openHomeActivity()
            }

            override fun onError(e: Throwable) {
                isLoading.postValue(false)
                mNavigator?.get()?.handleError(e)
            }
        }

        apiService.doLoginApiCall(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

        compositeDisposable.add(observer)
    }
}