package com.lhd.demo.firebaselogcat.fb_logcat

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

object FirebaseLogcat {

    private lateinit var context: Context
    private var enableLog = true

    private val firebaseAnalytics: FirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(context)
    }

    fun initialize(context: Context) {
        this.context = context
        Firebase.initialize(context)
    }

    fun enableLog(enableLog: Boolean) {
        this.enableLog = enableLog
    }
    fun logEvent(eventKey: String, message: Any?) {
        val logeEvent = LogEvent(message)
        logEvent(eventKey, logeEvent)
    }

    fun logEvent(eventKey: String, logeEvent: LogEvent) {
        if (enableLog) {
            firebaseAnalytics.logEvent(eventKey) {
                param(logeEvent.tag, logeEvent.getMessage())
            }
        }
    }

}