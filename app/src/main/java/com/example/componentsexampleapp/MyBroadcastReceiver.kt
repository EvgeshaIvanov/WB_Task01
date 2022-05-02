package com.example.componentsexampleapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if (isAirPlaneModeEnabled) {
            Toast.makeText(context, "Режим полета включен", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Режим полета выключен", Toast.LENGTH_LONG).show()
        }
    }
}