package com.java.projet_android_restoy_duciel.Boardgame.view.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.java.projet_android_restoy_duciel.Boardgame.view.mapper.fromUiToRoom
import com.java.projet_android_restoy_duciel.Boardgame.view.model.BoardgameUI
import com.java.projet_android_restoy_duciel.Boardgame.view.model.ObjectForUi
import com.java.projet_android_restoy_duciel.Boardgame.view.viewmodel.SearchBoardgameViewModel
import com.java.projet_android_restoy_duciel.databinding.ActivitySearchBoardgameViewBinding
import fr.upjv.ccm.tp1.model.Boardgame
import fr.upjv.ccm.tp1.view.BoardgameAdapter


class SearchBoardgameViewActivity : AppCompatActivity() {

    private lateinit var adapter: BoardgameAdapter
    private lateinit var binding: ActivitySearchBoardgameViewBinding
    private lateinit var viewModel: SearchBoardgameViewModel

    private val BoardgameListObserver = Observer<List<ObjectForUi>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBoardgameViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val searchEditText: EditText = binding.editTextSearch

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                           before: Int, count: Int) {
                Snackbar.make(searchEditText, s, Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()

                viewModel.fetchData(text = s.toString())

           }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        viewModel = ViewModelProvider(this)[SearchBoardgameViewModel::class.java]

        // Create the instance of adapter
        adapter = BoardgameAdapter() { item, view ->
            onItemClick(item, view)
        }
        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

    }


    override fun onStart() {
        super.onStart()
        viewModel.searchBoardgameList.observe(this, BoardgameListObserver)
    }


    override fun onStop() {
        super.onStop()
        viewModel.searchBoardgameList.removeObserver(BoardgameListObserver)
    }


    private fun onItemClick(boardgameUI: BoardgameUI, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK)
        Toast.makeText(this, boardgameUI.name + " Successfully added !", Toast.LENGTH_LONG).show()
        Log.v("TEST", boardgameUI.toString());
        viewModel.insertBoardGame(boardgameUI.fromUiToRoom())
        finish()
    }

}
