package ninja.shuza.androidMvvm.networkIO.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import java.lang.reflect.Type

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

class LoginDeserializer : BaseDeserializer<LoginResponse>() {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): LoginResponse {
        val model = LoginResponse()
        val jsonObj = json.asJsonObject

        model.id = parseInt(jsonObj, "id")
        model.userId = parseInt(jsonObj, "userId")
        model.token = parseString(jsonObj, "authToken")
        model.refreshToken = parseString(jsonObj, "refreshToken")
        model.isActive = parseBoolean(jsonObj, "active")

        return model
    }
}