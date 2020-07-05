package com.ardyyy.dev.androidmvvm.utils

import android.content.Context
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_profile.view.*


fun Context.showShortToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun RadioGroup.setEnable(isEnable: Boolean){
    for(i in 0 until this.childCount){
        (rg_gender.getChildAt(i) as RadioButton).isEnabled = isEnable
    }
}