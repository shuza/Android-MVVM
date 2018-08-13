package ninja.shuza.androidMvvm.networkIO.deserializer

import java.util.*

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

class LoginResponse {
    var id = 0
    var userId = 0
    var token = ""
    var refreshToken = ""
    var expireDate: Date? = null
    var isActive = false
}