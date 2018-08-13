package ninja.shuza.androidMvvm.ui.login

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

interface LoginNavigator{
    fun login()
    fun handleError(throwable: Throwable)
    fun openHomeActivity()
}