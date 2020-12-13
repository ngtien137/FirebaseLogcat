package com.lhd.demo.firebaselogcat

import android.app.Application

class App : Application() {

    companion object {
        private lateinit var app: App
        fun self() = app
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

}