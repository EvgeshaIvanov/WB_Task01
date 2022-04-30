package com.example.componentsexampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.componentsexampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intentService = Intent(this, ServiceExampleActivity::class.java)
        val intentReceiver = Intent(this, ServiceExampleActivity::class.java)
        val intentContentProvider = Intent(this, ServiceExampleActivity::class.java)
        binding.apply {
            serviceButton.setOnClickListener {
                startActivity(intentService)
            }
            receiverButton.setOnClickListener {
                startActivity(intentReceiver)
            }
            contextProviderButton.setOnClickListener {
                startActivity(intentContentProvider)
            }
        }

    }
}