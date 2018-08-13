package ninja.shuza.androidMvvm.networkIO

import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject

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

fun createLoginRequestBody(username: String, password: String): RequestBody {
    val requestObj = JSONObject()
    requestObj.put("username", username)
    requestObj.put("password", password)

    return RequestBody.create(MediaType.parse("application/json"), requestObj.toString())
}