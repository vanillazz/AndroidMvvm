package com.ardyyy.dev.androidmvvm.presentation.base

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), BaseView {

    private var baseActivity: BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.baseActivity = activity
        }
    }

    override fun showLoading() {
        if (baseActivity != null) {
            baseActivity?.showLoading()
        }
    }

    override fun hideLoading() {
        if (baseActivity != null) {
            baseActivity?.hideLoading()
        }
    }
}