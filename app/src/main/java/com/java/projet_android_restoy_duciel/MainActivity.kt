package com.java.projet_android_restoy_duciel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.java.projet_android_restoy_duciel.SW.view.RecyclerViewActivitySW
import com.java.projet_android_restoy_duciel.databinding.ActivityMainBinding
import com.java.projet_android_restoy_duciel.databinding.ActivitySwBinding


private lateinit var binding: ActivityMainBinding
private lateinit var bindingSW: ActivitySwBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnFunc2.setOnClickListener{
            goToRecyclerViewSW();
        }
    }

    private fun goToRecyclerViewSW(){
        val intent = Intent(this, RecyclerViewActivitySW::class.java)
        startActivity(intent)
    }
}


