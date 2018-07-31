package ninja.shuza.androidMvvm.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import ninja.shuza.androidMvvm.model.database.AppDatabase
import ninja.shuza.androidMvvm.ui.post.PostListViewModel

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  01-Aug-2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "posts").build()

            @Suppress("UNKNOWN_CAST")
            return PostListViewModel(db.postDao()) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}