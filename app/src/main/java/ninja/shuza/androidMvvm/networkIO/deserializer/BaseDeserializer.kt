package ninja.shuza.androidMvvm.networkIO.deserializer

import com.google.gson.JsonArray
import com.google.gson.JsonDeserializer
import com.google.gson.JsonObject
import com.orhanobut.logger.Logger

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
abstract class BaseDeserializer<V> : JsonDeserializer<V> {
    /**
     *  check key has value and value is not NULL
     */
    fun hasValidValue(jsonObj: JsonObject, key: String): Boolean {
        return jsonObj.has(key) && !jsonObj.get(key).isJsonNull
    }

    /**
     *  parse key value to string
     *  if any error arise return empty string
     */
    fun parseString(jsonObj: JsonObject, key: String): String {
        try {
            return jsonObj.get(key).asString
        } catch (e: Exception) {
            Logger.e("Parse String Error:  ${e.message}")
        }

        return ""
    }

    /**
     *  parse key value to Int
     *  if any error arise return min Int value as default
     */
    fun parseInt(jsonObj: JsonObject, key: String): Int {
        try {
            return jsonObj.get(key).asInt
        } catch (e: Exception) {
            Logger.e("Parse Int Error:  ${e.message}")
        }

        return 0
    }

    /**
     *  parse key value to Double
     *  if any error arise return min Double value as default
     */
    fun parseDouble(jsonObj: JsonObject, key: String): Double {
        try {
            return jsonObj.get(key).asDouble
        } catch (e: Exception) {
            Logger.e("Double Int Error:  ${e.message}")
        }

        return 0.0
    }

    /**
     *  parse key value to Boolean
     *  if any error arise return false
     */
    fun parseBoolean(jsonObj: JsonObject, key: String): Boolean {
        try {
            return jsonObj.get(key).asBoolean
        } catch (e: Exception) {
            Logger.e("Boolean Int Error:  ${e.message}")
        }

        return false
    }

    /**
     *  parse key value to JsonObject
     *  if any error arise return NULL
     */
    fun parseObject(jsonObj: JsonObject, key: String): JsonObject? {
        try {
            return jsonObj.get(key).asJsonObject
        } catch (e: Exception) {
            Logger.e("Object Int Error:  ${e.message}")
        }

        return null
    }

    /**
     *  parse key value to JsonArray
     *  if any error arise return NULL
     */
    fun parseArray(jsonObj: JsonObject, key: String): JsonArray? {
        try {
            return jsonObj.get(key).asJsonArray
        } catch (e: Exception) {
            Logger.e("Parse Array Error:  ${e.message}")
        }

        return null
    }
}