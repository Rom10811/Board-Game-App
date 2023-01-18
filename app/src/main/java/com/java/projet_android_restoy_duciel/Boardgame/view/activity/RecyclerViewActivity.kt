package com.java.projet_android_restoy_duciel.Boardgame.view.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.java.projet_android_restoy_duciel.Boardgame.view.model.BoardgameUI
import com.java.projet_android_restoy_duciel.Boardgame.view.model.ObjectForUi
import com.java.projet_android_restoy_duciel.Boardgame.view.viewmodel.BoardgameViewModel
import com.java.projet_android_restoy_duciel.Notification.CustomNotificationManager
import com.java.projet_android_restoy_duciel.R
import com.java.projet_android_restoy_duciel.databinding.ActivityRecyclerViewBinding
import fr.upjv.ccm.tp1.view.BoardgameAdapter

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: BoardgameAdapter
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var viewModel: BoardgameViewModel

    private val BoardgameListObserver = Observer<List<ObjectForUi>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fab: View = binding.fab
        val fabrm: View = binding.fabremove

        fab.setOnClickListener { view ->
            startActivity(Intent(this, SearchBoardgameViewActivity::class.java))
            Snackbar.make(view, "Feature en cours de developpement", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

        fabrm.setOnClickListener { _ ->
            viewModel.deleteAll()
        }

        viewModel = ViewModelProvider(this)[BoardgameViewModel::class.java]

        // Create the instance of adapter
        adapter = BoardgameAdapter { item, _ ->
            onItemClick(item)
        }
        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

    }


    override fun onStart() {
        super.onStart()
        viewModel.boardgameLiveData.observe(this, BoardgameListObserver)
    }

    override fun onStop() {
        super.onStop()
        viewModel.boardgameLiveData.observe(this, BoardgameListObserver)
    }

    private fun onItemClick(boardgame: BoardgameUI) {
        viewModel.deleteOneBoardgame(boardgame.name)
        with(CustomNotificationManager(this)){
            createNotificationCompatBuilder(boardgame.name)
        }
    }

}