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
  //if you enalbe crashlytics
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
