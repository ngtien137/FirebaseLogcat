package com.lhd.demo.firebaselogcat.fb_logcat

class LogEvent(
    private var message: Any?, val tag: String = "DefaultEvent"
) {

    fun getMessage() = message?.toString() ?: "[null]"

}