package com.learning.catz.commons

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class APIDateParser @Inject constructor() {

    fun parse(apiDate: String?) =
        SimpleDateFormat(
            API_DATE_FORMAT,
            Locale.getDefault()
        ).parse(apiDate.orEmpty()) ?: Date()

    companion object {
        private const val API_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
    }
}