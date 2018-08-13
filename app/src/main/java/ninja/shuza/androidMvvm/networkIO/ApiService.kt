package ninja.shuza.androidMvvm.networkIO

import io.reactivex.Observable
import ninja.shuza.androidMvvm.networkIO.deserializer.LoginResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

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

interface ApiService{
    @POST("user/login")
    fun doLoginApiCall(@Body body: RequestBody): Observable<LoginResponse>
}