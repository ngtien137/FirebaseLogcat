package com.lhd.demo.firebaselogcat.fb_logcat

import android.app.Activity
import android.content.Context

fun Context.initFirebaseLogcat() {
    firebaseLogcat = FirebaseLogcat(this)
}

private lateinit var firebaseLogcat: FirebaseLogcat

fun Activity.logEvent(message: Any?) {
    firebaseLogcat.logEvent(this::class.java.simpleName, message)
}

fun Activity.logEvent(tag: String, message: Any?) {
    firebaseLogcat.logEvent(this::class.java.simpleName, LogEvent(message, tag))
}

fun logeEvent(eventKey: String, logEvent: LogEvent) {
    firebaseLogcat.logEvent(eventKey, logEvent)
}