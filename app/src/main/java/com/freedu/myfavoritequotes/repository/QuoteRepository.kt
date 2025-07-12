package com.freedu.myfavoritequotes.repository

import android.content.Context
import com.freedu.myfavoritequotes.utils.SharedPrefHelper
import com.freedu.myfavoritequotes.model.Quote

class QuoteRepository(context: Context) {
    private val prefHelper = SharedPrefHelper(context)

    fun getQuotes(): List<Quote> {
        return prefHelper.getQuotes()
    }

    fun saveQuote(quotes: List<Quote>) {
        return prefHelper.saveQuotes(quotes)
    }
}