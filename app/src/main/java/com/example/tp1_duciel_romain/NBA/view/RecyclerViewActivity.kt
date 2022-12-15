package com.example.tp1_duciel_romain.NBA.view

import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1_duciel_romain.databinding.ActivityRecyclerViewBinding
import com.example.tp1_duciel_romain.NBA.model.MyObjectForRecyclerView
import com.example.tp1_duciel_romain.NBA.model.RecyclerViewData
import com.example.tp1_duciel_romain.NBA.viewmodel.NBATeamViewModel
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: NBATeamAdapter
    private lateinit var viewModel: NBATeamViewModel

    private val nbaTeamListObserver = Observer<List<MyObjectForRecyclerView>>{
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[NBATeamViewModel::class.java]

        // Create the instance of adapter
        adapter = NBATeamAdapter { item, view ->
            onItemClick(item, view)
        }

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

        binding.addItemButton.setOnClickListener{addNBATeam()}

        binding.deleteAllItemButton.setOnClickListener{removeAllNBATeam()}

    }

    override fun onStart() {
        super.onStart()
        viewModel.nbaTeamList.observe(this, nbaTeamListObserver)
    }


    override fun onStop() {
        super.onStop()
        viewModel.nbaTeamList.removeObserver(nbaTeamListObserver)
    }


    private fun onItemClick(objectDataSample: RecyclerViewData, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this, objectDataSample.teamName, Toast.LENGTH_LONG).show()
    }


    var estRankCount = 0
    var ouestRankCount = 0
    private fun addNBATeam()
    {
        val arr = arrayOf("Est", "Ouest")
        val randomConf = Random.nextInt(0,2)
        val random = Random.nextInt(1,999)
        if(randomConf == 0)
        {
            estRankCount += 1
            viewModel.insertNBATeam("NBA $random", arr[randomConf], estRankCount, "https://upload.wikimedia.org/wikipedia/fr/thumb/8/87/NBA_Logo.svg/1200px-NBA_Logo.svg.png")
        }
        else
        {
            ouestRankCount +=1
            viewModel.insertNBATeam("NBA $random", arr[randomConf], ouestRankCount, "https://upload.wikimedia.org/wikipedia/fr/thumb/8/87/NBA_Logo.svg/1200px-NBA_Logo.svg.png")
        }
    }

    private fun removeAllNBATeam()
    {
        viewModel.deleteAllNBATeam()
        estRankCount = 0
        ouestRankCount = 0
    }
}