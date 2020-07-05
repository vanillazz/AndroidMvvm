package com.ardyyy.dev.androidmvvm.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import com.ardyyy.dev.androidmvvm.R
import com.ardyyy.dev.androidmvvm.data.local.entity.User
import com.ardyyy.dev.androidmvvm.utils.createCircularProgress
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    companion object {
        var EXTRAS_USERS: String = "extras_user"
    }

    private var mUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
        getBundle()
        bindData()
    }

    private fun initLayout() {
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getBundle() {
        mUser = intent.getParcelableExtra(EXTRAS_USERS)
    }

    private fun bindData() {
        mUser?.let {
            with(it){
                iv_detail_avatar.load(avatar) {
                    crossfade(true)
                    placeholder(createCircularProgress(this@DetailActivity))
                }
                tv_detail_title.text = "$firstName $lastName"
                tv_detail_email.text = email
            }
        }
    }

}