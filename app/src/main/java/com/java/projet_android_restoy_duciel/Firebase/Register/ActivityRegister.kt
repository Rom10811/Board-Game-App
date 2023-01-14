package com.java.projet_android_restoy_duciel.Firebase.Register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.java.projet_android_restoy_duciel.databinding.ActivityRegisterBinding

private lateinit var bindingRegister: ActivityRegisterBinding
private lateinit var auth: FirebaseAuth

class ActivityRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        bindingRegister = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(bindingRegister.root)

        bindingRegister.btnRegister.setOnClickListener {
            createAccount(bindingRegister.registerUsername.text.toString(), bindingRegister.registerPassword.text.toString())
        }
    }


    private fun createAccount(username: String, password: String) {
        auth.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    this.finish();
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}