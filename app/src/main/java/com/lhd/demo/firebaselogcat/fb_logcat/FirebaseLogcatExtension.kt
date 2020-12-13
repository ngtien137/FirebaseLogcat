package com.lhd.demo.firebaselogcat.fb_logcat

fun logEvent(eventKey: String, logEvent: LogEvent) {
    FirebaseLogcat.logEvent(eventKey, logEvent)
}

fun logEvent(eventKey: String, message: Any?) {
    FirebaseLogcat.logEvent(eventKey, message)
}
