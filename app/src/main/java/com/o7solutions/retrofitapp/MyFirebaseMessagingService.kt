package com.o7solutions.retrofitapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.Calendar


/**
 * @Author: 017
 * @Date: 28/06/23
 * @Time: 12:58 pm
 */
class MyFirebaseMessagingService : FirebaseMessagingService(){

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        System.out.println("in message received "+message.notification?.title)

        //var notification
        var intent = Intent(this, MainActivity::class.java)
        var pendingIntent = PendingIntent.getActivity(
            this, Calendar.getInstance().timeInMillis.toInt(),
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val notificationSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationBuilder = NotificationCompat.Builder(this, applicationContext.resources.getString(R.string.app_name))
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(message.notification?.title)
            .setContentText(message.notification?.body)
            .setAutoCancel(true)
            .setSound(notificationSoundUri)
            .setContentIntent(pendingIntent)

            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                NotificationChannel("Customer", "Customer", importance).apply {
                    description = "Customer"
                    enableLights(true)
                    setImportance(NotificationManager.IMPORTANCE_HIGH)
                    setShowBadge(true)
                  //  setSound(notificationSoundUri, AudioAttributes())
                }
            notificationManager.createNotificationChannel(channel)
            notificationBuilder.setChannelId("Customer")


        notificationManager.notify(1, notificationBuilder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        System.out.println("in token $token")
        //save
    }

}