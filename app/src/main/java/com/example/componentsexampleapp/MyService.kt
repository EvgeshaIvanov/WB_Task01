package com.example.componentsexampleapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService : Service() {

    /*
    Создаем фоновый сервис (background service). В данном примере будет показан плеер
    который будет работать в фоновом режиме.
     */

    lateinit var player: MediaPlayer
    /*
    В данном примере мы не будем связывать сервис с др. компонентами, но по умолчанию данный метод
    должен быть реализован и возвращать null
    */
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    /*
    Реализуем метод, который будет запускаться при обращении к сервису (startService()). Возвращаться будет
    константа START_STICKY - сервис будет перезапущен после того, как был завершен системой.
    Здесь описываем работу плеера.
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI)
        player.isLooping
        player.start()
        return START_STICKY
    }
    //Создаем метод, при котором сервис завершается системой, после вызова stopService().
    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
}