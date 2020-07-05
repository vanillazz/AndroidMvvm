package com.ardyyy.dev.androidmvvm.presentation.home.ui.profile

import androidx.lifecycle.ViewModel
import com.ardyyy.dev.androidmvvm.data.local.entity.User
import com.ardyyy.dev.androidmvvm.di.PreferenceManager
import com.ardyyy.dev.androidmvvm.utils.AppConstant.PREF_EMAIL
import com.ardyyy.dev.androidmvvm.utils.AppConstant.PREF_FIRSTNAME
import com.ardyyy.dev.androidmvvm.utils.AppConstant.PREF_GENDER
import com.ardyyy.dev.androidmvvm.utils.AppConstant.PREF_LASTNAME

class ProfileViewModel(
    private val preferenceManager: PreferenceManager
) : ViewModel() {

    fun getUserPref(): User{
        val firstName = preferenceManager.getString(PREF_FIRSTNAME, "")
        val lastName = preferenceManager.getString(PREF_LASTNAME, "")
        val email = preferenceManager.getString(PREF_EMAIL, "")
        val gender = preferenceManager.getBoolean(PREF_GENDER, true)
        return User(firstName = firstName, lastName = lastName, email = email, gender = gender)
    }

    fun saveUserPref(
        firstname: String,
        lastname: String,
        email: String,
        isMale: Boolean
    ) {
        preferenceManager.saveString(PREF_FIRSTNAME, firstname)
        preferenceManager.saveString(PREF_LASTNAME, lastname)
        preferenceManager.saveString(PREF_EMAIL, email)
        preferenceManager.saveBoolean(PREF_GENDER, isMale)
    }
}