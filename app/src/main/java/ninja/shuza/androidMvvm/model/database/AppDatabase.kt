package ninja.shuza.androidMvvm.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ninja.shuza.androidMvvm.model.Post
import ninja.shuza.androidMvvm.model.PostDao

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

@Database(entities = [(Post::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}