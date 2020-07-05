package com.ardyyy.dev.androidmvvm.presentation.base

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import com.ardyyy.dev.androidmvvm.R

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var mProgressDialog: ProgressDialog? = null

    override fun showLoading() {
        hideLoading()

        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.setMessage(getString(R.string.loading))
            mProgressDialog!!.isIndeterminate = true
            mProgressDialog!!.setCancelable(false)
            mProgressDialog!!.setCanceledOnTouchOutside(false)
        }
        mProgressDialog!!.show()
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }
}