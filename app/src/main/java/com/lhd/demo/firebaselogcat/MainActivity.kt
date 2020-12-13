package com.lhd.demo.firebaselogcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.lhd.demo.firebaselogcat.databinding.ActivityMainBinding
import com.lhd.demo.firebaselogcat.fb_logcat.FirebaseLogcat
import com.lhd.demo.firebaselogcat.fb_logcat.LogEvent
import com.lhd.demo.firebaselogcat.fb_logcat.logEvent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseLogcat.initialize(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    fun sendLog(view: View) {
        val tag = binding.edtTag.text.toString()
        val message = binding.edtContent.text.toString()
        if (message.isEmpty()) {
            Toast.makeText(this, "Message log is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if (tag.isEmpty()) {
            logEvent(MainActivity::class.java.simpleName, message)
        } else {
            logEvent(MainActivity::class.java.simpleName, LogEvent(message, tag))
        }
    }

    fun openFragment(view: View) {}
    fun sendLogWithCustomEvent(view: View) {
        val tag = binding.edtTag.text.toString()
        val message = binding.edtContent.text.toString()
        if (message.isEmpty()) {
            Toast.makeText(this, "Message log is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if (tag.isEmpty()) {
            logEvent("my_custom_event_empty_tag", LogEvent(message))
        } else {
            logEvent("my_custom_event_has_$tag", LogEvent(message, tag))
        }
    }
}