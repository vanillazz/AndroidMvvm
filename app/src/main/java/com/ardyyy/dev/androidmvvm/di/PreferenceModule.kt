package com.ardyyy.dev.androidmvvm.di

import android.content.Context
import androidx.core.content.edit
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val PREFERENCE_NAME = "preference_name"

val preferenceModule = module {

    single(named(PREFERENCE_NAME)) { "prefences" }

    single<PreferenceManager> { PreferenceManagerImpl(get(), get(named(PREFERENCE_NAME))) }

}

class PreferenceManagerImpl(context: Context, prefName: String): PreferenceManager{

    private val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    override fun getBoolean(key: String, default: Boolean): Boolean {
        return sharedPref.getBoolean(key, default)
    }

    override fun getString(key: String, default: String): String {
        return sharedPref.getString(key, default).toString()
    }

    override fun saveBoolean(key: String, value: Boolean) {
        sharedPref.edit {
            putBoolean(key, value)
            commit()
        }
    }

    override fun saveString(key: String, value: String) {
        sharedPref.edit {
            putString(key, value)
            commit()
        }
    }

}

interface PreferenceManager {
    fun getBoolean(key: String, default: Boolean): Boolean

    fun getString(key: String, default: String): String

    fun saveBoolean(key: String, value: Boolean)

    fun saveString(key: String, value: String)
}