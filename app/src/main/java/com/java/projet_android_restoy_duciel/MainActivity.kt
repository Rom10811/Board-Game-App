package com.java.projet_android_restoy_duciel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.java.projet_android_restoy_duciel.Boardgame.view.activity.RecyclerViewActivity
import com.java.projet_android_restoy_duciel.Firebase.Login.ActivityLogin
import com.java.projet_android_restoy_duciel.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnFunc2.setOnClickListener{
            goToRecyclerViewBoardgames();
        }

        binding.btnFunc3.setOnClickListener {
            goToFirebaseActivity();
        }
    }


    private fun goToRecyclerViewBoardgames(){
        val intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }

    private fun goToFirebaseActivity() {
        val intent = Intent(this, ActivityLogin::class.java)
        startActivity(intent)
    }
}


