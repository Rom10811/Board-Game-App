package com.java.projet_android_restoy_duciel.Firebase.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.java.projet_android_restoy_duciel.Firebase.Register.ActivityRegister
import com.java.projet_android_restoy_duciel.Notification.NotificationActivity
import com.java.projet_android_restoy_duciel.databinding.ActivityLoginBinding

private lateinit var bindingLogin: ActivityLoginBinding
private lateinit var auth: FirebaseAuth

class ActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindingLogin.root)

        bindingLogin.btnLogin.setOnClickListener {
            if (bindingLogin.username.text.isNotEmpty() && bindingLogin.password.text.isNotEmpty()) {
                firebaseLogin(
                    bindingLogin.username.text.toString(),
                    bindingLogin.password.text.toString()
                )
            } else {
                Toast.makeText(
                    baseContext, "Veuillez renseigner les champs.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        bindingLogin.btnGoToInscription.setOnClickListener {
            goToInscriptionView();
        }

    }


    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            goToNotificationView();
        }
    }

    private fun firebaseLogin(username: String, password: String) {
        auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    finish()
                    val intent = Intent(this, NotificationActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun goToInscriptionView() {
        val intent = Intent(this, ActivityRegister::class.java)
        startActivity(intent);
    }

    private fun goToNotificationView() {
        val intent = Intent(this, NotificationActivity::class.java)
        startActivity(intent);
    }
}