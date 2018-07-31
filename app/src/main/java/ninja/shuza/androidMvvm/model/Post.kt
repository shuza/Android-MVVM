package ninja.shuza.androidMvvm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

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

@Entity
data class Post(
        val userId: Int,

        @field:PrimaryKey
        val id: Int,

        val title: String,
        val body: String

)