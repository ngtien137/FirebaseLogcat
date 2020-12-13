package com.lhd.demo.firebaselogcat.fb_logcat

class LogEvent(
    private var message: Any?, val tag: String = "DefaultTAG"
) {

    fun getMessage() = message?.toString() ?: "[null]"

}