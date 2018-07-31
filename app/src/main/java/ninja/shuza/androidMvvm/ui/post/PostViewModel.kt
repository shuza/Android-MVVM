package ninja.shuza.androidMvvm.ui.post

import android.arch.lifecycle.MutableLiveData
import ninja.shuza.androidMvvm.base.BaseViewModel
import ninja.shuza.androidMvvm.model.Post

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

class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle() = postTitle
    fun getPostBody() = postBody
}