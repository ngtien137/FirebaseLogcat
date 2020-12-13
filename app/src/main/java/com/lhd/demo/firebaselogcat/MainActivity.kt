package com.lhd.demo.firebaselogcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.lhd.demo.firebaselogcat.databinding.ActivityMainBinding
import com.lhd.demo.firebaselogcat.fb_logcat.initFirebaseLogcat
import com.lhd.demo.firebaselogcat.fb_logcat.logEvent
import com.lhd.demo.firebaselogcat.fb_logcat.logeEvent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        initFirebaseLogcat()
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
            logEvent(message)
        } else {
            logEvent(tag, message)
        }
    }

    fun openFragment(view: View) {}
}