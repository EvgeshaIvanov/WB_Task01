package com.example.componentsexampleapp

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.componentsexampleapp.databinding.ActivityReceiverExampleBinding

class ReceiverExampleActivity : AppCompatActivity() {

    /*
    Приложения - WhatsApp, Viber, Skype
    Создаем экземпляр класса приёмника
     */

    lateinit var receiver: MyBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_example)
        receiver = MyBroadcastReceiver()
        //Создаем фильтр на определенное действие и регистрируем приёмник
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
    }

    //выключаем приёмник при выходе из активити
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}