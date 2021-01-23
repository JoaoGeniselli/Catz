package com.learning.catz.commons

import java.text.DateFormat
import java.util.*
import javax.inject.Inject

class DateFormatter @Inject constructor() {
    fun format(date: Date): String = DateFormat.getDateTimeInstance().format(date)
}