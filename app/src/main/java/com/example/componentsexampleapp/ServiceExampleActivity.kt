package com.example.componentsexampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.componentsexampleapp.databinding.ActivityServiceExampleBinding

class ServiceExampleActivity : AppCompatActivity() {

    // приложения - Spotify, Soundcloud, Яндекс музыка

    lateinit var binding: ActivityServiceExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // добавляем запуск и остановку сервиса на кнопки
        binding.apply {
            playButton.setOnClickListener {
                startService(Intent(this@ServiceExampleActivity,MyService::class.java))
            }
            stopButton.setOnClickListener {
                stopService(Intent(this@ServiceExampleActivity,MyService::class.java))
            }
        }
    }

}