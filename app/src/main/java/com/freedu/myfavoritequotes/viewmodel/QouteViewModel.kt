package com.freedu.myfavoritequotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.freedu.myfavoritequotes.model.Quote
import com.freedu.myfavoritequotes.repository.QuoteRepository

class QouteViewModel(application: Application):AndroidViewModel(application) {
    private val repository = QuoteRepository(application)
    private val _quotes = MutableLiveData<List<Quote>>()
    val qoutes:LiveData<List<Quote>> = _quotes

    init {
        loadQuotes()
    }

    private fun loadQuotes() {
        _quotes.value = repository.getQuotes()
    }

    fun addQuote(quote: Quote) {
        val updated = _quotes.value.orEmpty().toMutableList()
        updated.add(quote)
        _quotes.value = updated
        repository.saveQuote(updated)
    }

    fun deleteQuote(quote: Quote) {
        val updated = _quotes.value.orEmpty().toMutableList()
        updated.remove(quote)
        _quotes.value = updated
        repository.saveQuote(updated)
    }
}