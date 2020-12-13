package com.lhd.demo.firebaselogcat.fb_logcat

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class FirebaseLogcat(private val context: Context) {

    init {
        Firebase.initialize(context)
    }

    private val firebaseAnalytics: FirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(context)
    }

    fun logEvent(eventKey: String, message: Any?) {
        val logeEvent = LogEvent(message)
        logEvent(eventKey, logeEvent)
    }

    fun logEvent(eventKey: String, logeEvent: LogEvent) {
        firebaseAnalytics.logEvent(eventKey) {
            param(logeEvent.tag, logeEvent.getMessage())
        }
    }

}