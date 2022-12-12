package com.example.tp1_duciel_romain

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1_duciel_romain.databinding.ActivityMainBinding
import com.example.tp1_duciel_romain.databinding.ActivityRecyclerViewBinding
import com.example.tp1_duciel_romain.view.RecyclerViewActivity


private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoToRecyclerActivity.setOnClickListener{
            goToRecyclerView();
        }
    }

    private fun goToRecyclerView(){
        val intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }
}


