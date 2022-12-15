package com.example.tp1_duciel_romain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp1_duciel_romain.NBA.view.RecyclerViewActivity
import com.example.tp1_duciel_romain.databinding.ActivityMainBinding
import com.example.tp1_duciel_romain.SW.view.RecyclerViewActivitySW
import com.example.tp1_duciel_romain.databinding.ActivitySwBinding


private lateinit var binding: ActivityMainBinding
private lateinit var bindingSW: ActivitySwBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoToRecyclerActivity.setOnClickListener{
            goToRecyclerView();
        }

        binding.btnGoToRecyclerActivitySW.setOnClickListener{
            goToRecyclerViewSW();
        }
    }

    private fun goToRecyclerView(){
        val intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }

    private fun goToRecyclerViewSW(){
        val intent = Intent(this, RecyclerViewActivitySW::class.java)
        startActivity(intent)
    }
}


