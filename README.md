# FirebaseLogcat
Demo Firebase Log Event
## Getting started
* Configure firebase and download google-services.json to your project
* build.gradle(Project)
```gradle
dependencies {
  ...
  classpath 'com.google.gms:google-services:4.3.4'
  classpath 'com.google.firebase:firebase-crashlytics-gradle:2.4.1'
}

allprojects {
  repositories {
    ...
    google()
  }
}

```

* build.gradle(Module:app)
```gradle
plugins {
  ...
  id 'com.google.gms.google-services'
  //enalbe crashlytics (if you want to use it)
  id 'com.google.firebase.crashlytics'
}

```

```gradle
dependencies {
//firebase
  implementation platform('com.google.firebase:firebase-bom:26.1.1')
  implementation 'com.google.firebase:firebase-analytics-ktx'

  //crashlytics
  implementation 'com.google.firebase:firebase-crashlytics'
}
```
## Components
* FirebaseLogcat class
This class has all features for logging event
* LogEvent class
This class containt data for logging
```kotlin
class LogEvent(
  private var message: Any?, val tag: String = "DefaultEvent"
) {

  fun getMessage() = message?.toString() ?: "[null]"
}
```
## Using
* Initialize before using FirebaseLogcat class
```kotlin 
  FirebaseLogcat.initialize(context)
```
* Enable logging feature (default is true)
```kotlin
  FirebaseLogcat.enableLog(true)
```
* Send Log by singleton class:
```kotlin
  var eventKey = "event_test"
  var message = "my message"
  var logEvent = LogEvent(message, "log_tag")
  FirebaseLogcat.logEvent(eventKey, logEvent) //logEvent: LogEvent
  //or
  FirebaseLogcat.logEvent(eventKey, message) //message:Any?
  // or using through extension functions
  logEvent(eventKey, logEvent)
  logEvent(eventKey, message)
  
  //if the tag is empty or you log without a tag, "DefaultTAG" will be generated
```
