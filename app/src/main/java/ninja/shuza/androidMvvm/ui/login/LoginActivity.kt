package ninja.shuza.androidMvvm.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import ninja.shuza.androidMvvm.MainActivity
import ninja.shuza.androidMvvm.R
import ninja.shuza.androidMvvm.ui.base.BaseActivity
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import javax.inject.Inject

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

class LoginActivity : BaseActivity<LoginViewModel>(), LoginNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun getLayoutId() = R.layout.activity_login

    override fun createViewModel(): LoginViewModel {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setNavigator(this)

        btn_login.onClick { login() }

        viewModel.isLoading.observe(this, Observer {
            it?.let {
                if (it) showLoadingDialog() else hideLoadingDialog()
            }
        })
    }

    override fun login() {
        val username = et_username.text.toString().trim()
        val password = et_password.text.toString().trim()

        if (viewModel.isValidUsernameAndPassword(username, password)) {
            viewModel.login(username, password)
        }
    }

    override fun handleError(throwable: Throwable) {
        toast("Error:  ${throwable.message}")
    }

    override fun openHomeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}