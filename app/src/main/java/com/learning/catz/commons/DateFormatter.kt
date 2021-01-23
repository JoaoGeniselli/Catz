package com.learning.catz.commons

import java.text.DateFormat
import java.util.*

class DateFormatter {
    fun format(date: Date): String = DateFormat.getDateTimeInstance().format(date)
}