package com.freedu.myfavoritequotes.utils

import android.content.Context
import android.content.SharedPreferences
import com.freedu.myfavoritequotes.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPrefHelper(context:Context) {
    private val sharedPref:SharedPreferences = context.getSharedPreferences("quotes_pref", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveQuotes(quotes: List<Quote>) {
        val json = gson.toJson(quotes)
        sharedPref.edit().putString("quotes_list", json).apply()
    }

    fun getQuotes(): List<Quote> {
        val json = sharedPref.getString("quotes_list", null)
        return if (json != null) {
            val type = object : TypeToken<List<Quote>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }
}