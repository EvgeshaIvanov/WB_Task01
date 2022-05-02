package com.example.componentsexampleapp

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.componentsexampleapp.databinding.ActivityReceiverExampleBinding

class ReceiverExampleActivity : AppCompatActivity() {
    lateinit var binding: ActivityReceiverExampleBinding
    lateinit var receiver: MyBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiverExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        receiver = MyBroadcastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
        Log.d("MyLog","приемник выключен")
    }
}