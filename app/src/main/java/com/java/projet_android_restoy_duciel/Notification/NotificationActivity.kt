package com.java.projet_android_restoy_duciel.Notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.java.projet_android_restoy_duciel.R
import com.java.projet_android_restoy_duciel.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    private lateinit var bindingNotification: ActivityNotificationBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        bindingNotification = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(bindingNotification.root)

        bindingNotification.btnDisconnect.setOnClickListener{
            firebaseLogout()
        }
    }


    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            bindingNotification.labelUserId.text = currentUser.uid
        }
        else{
            finish()
        }
    }

    private fun firebaseLogout() {
        auth.signOut()
        finish()
    }
}

class CustomNotificationManager(private val context: Context) {

    companion object {
        const val TAG = "CustomNotificationManager"
        private const val CHANNEL_ID = "delete_purpose"
        private const val CHANNEL_NAME = "Channel notification on delete"
        private const val CHANNEL_DESCRIPTION = "This channel will received only delete notification"
        private const val REQUEST_CODE = 94043
        private const val NOTIFICATION_ID = 42
    }

    /** Notification manager*/
    private val mNotificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    init {
        if (!channelNotificationExists()) {
            createNowPlayingChannel()
        }
    }

    fun createNotificationCompatBuilder(Name: String) {
        val notificationCompat = NotificationCompat.Builder(context, CHANNEL_ID)
            .setAutoCancel(true)
            .setContentTitle(Name)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("$Name a été supprimé")
            )
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(NOTIFICATION_ID, notificationCompat.build())
        }
    }

    /**
     * Check if channel is already created
     */
    private fun channelNotificationExists() = mNotificationManager.getNotificationChannel(CHANNEL_ID) != null

    /**
     * Create the cancel id for notification
     */
    private fun createNowPlayingChannel() {
        val notificationChannel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = CHANNEL_DESCRIPTION
        }
        mNotificationManager.createNotificationChannel(notificationChannel)
    }
}
