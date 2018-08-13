package ninja.shuza.androidMvvm.ui.base

import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import ninja.shuza.androidMvvm.R
import kotlin.properties.Delegates

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

abstract class BaseActivity<V : BaseViewModel<*>> : AppCompatActivity() {
    var progressDialog: ProgressDialog by Delegates.notNull()
    var viewModel: V by Delegates.notNull()

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int


    /**
     * Override to create and set viewModel
     *
     * @return view model instance
     */
    abstract fun createViewModel(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        performDataBinding()

        progressDialog = ProgressDialog(this)
        progressDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog.setContentView(R.layout.progress_dialog)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
    }

    fun showLoadingDialog() {
        progressDialog.show()
    }

    fun hideLoadingDialog() {
        if (progressDialog.isShowing)
            progressDialog.dismiss()
    }

    private fun performDataBinding() {
        viewModel = createViewModel()
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }
}