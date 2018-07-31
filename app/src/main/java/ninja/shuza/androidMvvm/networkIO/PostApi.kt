package ninja.shuza.androidMvvm.networkIO

import io.reactivex.Observable
import ninja.shuza.androidMvvm.model.Post
import retrofit2.http.GET

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

interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}