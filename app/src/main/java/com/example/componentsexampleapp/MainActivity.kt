package com.example.componentsexampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.componentsexampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*

    Создаем главную активити и наследуемся от подкласса AppCompatActivity.
    Для взаимодействия с View подлключаем View Binding.
     */
    lateinit var binding: ActivityMainBinding
    /*
    Функция onCreate вызывается при создании экземпляра подкласса активити.
    Для того, чтобы предоставить активити UI, нужно вызвать функцию setContentView - она заполнит
    макет и выведит его на экран.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Далее добавляем слушатели на кнопки и навигацию по др. активити.
        val intentService = Intent(this, ServiceExampleActivity::class.java)
        val intentReceiver = Intent(this, ReceiverExampleActivity::class.java)
        val intentContentProvider = Intent(this, ContentProviderExampleActivity::class.java)
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