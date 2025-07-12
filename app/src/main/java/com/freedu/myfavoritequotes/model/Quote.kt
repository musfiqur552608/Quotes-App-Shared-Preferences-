package com.freedu.myfavoritequotes.model

data class Quote(
    val id: Long = System.currentTimeMillis(),
    var text: String,
    var author: String
)
