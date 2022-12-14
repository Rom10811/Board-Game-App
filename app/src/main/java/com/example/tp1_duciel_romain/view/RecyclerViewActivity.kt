package com.example.tp1_duciel_romain.view

import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.AbsListView.RecyclerListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1_duciel_romain.databinding.ActivityRecyclerViewBinding
import com.example.tp1_duciel_romain.view.model.MyObjectForRecyclerView
import com.example.tp1_duciel_romain.view.model.ObjectDataFooterSample
import com.example.tp1_duciel_romain.view.model.ObjectDataHeaderSample
import com.example.tp1_duciel_romain.view.model.RecyclerViewData
import com.example.tp1_duciel_romain.viewmodel.NBATeamViewModel

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
}