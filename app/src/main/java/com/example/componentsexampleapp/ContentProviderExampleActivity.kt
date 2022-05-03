package com.example.componentsexampleapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.componentsexampleapp.databinding.ActivityContentProviderBinding


class ContentProviderExampleActivity : AppCompatActivity() {
    /*
    Приложения - GetContact, "Контакты +", мессенджеры и др.
    В данном примере показано получение контактов из телефонной книги.
     */


    private lateinit var binding: ActivityContentProviderBinding

    //создадим массив, в котором будут наши контакты
    private var arrayOfContacts = arrayListOf<String>()

    //указываем путь
    private val contactUri: Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentProviderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getContactInfo()
        //создаем listView для отображения наших контактов в виде списка
        val arrayAdapter: ArrayAdapter<*>
        val mListView = binding.listView
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayOfContacts)
        mListView.adapter = arrayAdapter

    }

    //Реализуем метод по получению списка контактов из телефонной книги
    @SuppressLint("Recycle", "Range")
    private fun getContactInfo() {
        //Проверяем разрешение на чтение контактов
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(),
                0
            )
        }
        /*
        Создаем запрос к нашим контактам и курсором проходимся по строкам, с помощью метода getColumnIndex
        извлекаем данные, которые хранятся в колонках и помещаем их в наш массив.
         */
        val cursor = contentResolver.query(contactUri, null, null, null, null)
        cursor?.let {
            while (it.moveToNext()) {
                val contactName =
                    it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val contactPhone =
                    it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                val newModel = "$contactName, $contactPhone"
                arrayOfContacts.add(newModel)
            }
        }
        cursor?.close()
    }

}