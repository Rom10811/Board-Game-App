package com.java.projet_android_restoy_duciel.Firebase.Login

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.java.projet_android_restoy_duciel.Firebase.Register.ActivityRegister
import com.java.projet_android_restoy_duciel.R
import com.java.projet_android_restoy_duciel.databinding.ActivityLoginBinding

private lateinit var bindingLogin: ActivityLoginBinding
private lateinit var auth: FirebaseAuth
private lateinit var labelUserId: TextView

class ActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindingLogin.root)

        bindingLogin.btnLogin.setOnClickListener {
            firebaseLogin(
                bindingLogin.username.text.toString(),
                bindingLogin.password.text.toString()
            )
        }

        bindingLogin.btnGoToInscription.setOnClickListener {
            goToInscriptionView();
        }

        bindingLogin.btnDisconnect.setOnClickListener {
            firebaseDisconnect();
        }

    }


    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            updateUI(currentUser)
        } else {
            bindingLogin.btnDisconnect.visibility = View.INVISIBLE
        }
    }

    private fun firebaseLogin(username: String, password: String) {
        auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("DATA", "signInWithEmail:success")
                    finish()
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("DATA", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


    private fun firebaseDisconnect() {
        auth.signOut()
        finish()
        startActivity(intent)
    }

    private fun updateUI(user: FirebaseUser?) {
        bindingLogin.btnLogin.visibility = View.INVISIBLE
        bindingLogin.username.visibility = View.INVISIBLE
        bindingLogin.password.visibility = View.INVISIBLE
        bindingLogin.btnGoToInscription.visibility = View.INVISIBLE
        bindingLogin.btnDisconnect.visibility = View.VISIBLE
        user?.let {
            val uid = user.uid
            bindingLogin.labelUserId.text = uid
        }
    }

    private fun goToInscriptionView() {
        val intent = Intent(this, ActivityRegister::class.java)
        startActivity(intent);
    }
}