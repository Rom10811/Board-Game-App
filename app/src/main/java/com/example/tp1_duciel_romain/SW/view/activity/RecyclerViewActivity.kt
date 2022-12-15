package com.example.tp1_duciel_romain.SW.view


import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1_duciel_romain.SW.domain.model.SWMonstersDomain
import com.example.tp1_duciel_romain.SW.view.model.ObjectForUi
import com.example.tp1_duciel_romain.SW.view.model.SWMonstersUi
import com.example.tp1_duciel_romain.SW.view.viewmodel.SWMonstersViewModel
import com.example.tp1_duciel_romain.databinding.ActivitySwBinding

class RecyclerViewActivitySW : AppCompatActivity() {
    private lateinit var binding: ActivitySwBinding
    private lateinit var viewModel: SWMonstersViewModel

    private val adapter: SWMonstersAdapter = SWMonstersAdapter()

    private val swMonstersListObserver = Observer<List<ObjectForUi>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[SWMonstersViewModel::class.java]


        // We define the style
        binding.SWActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.SWActivityRv.adapter = adapter

        binding.SWActivityAdd.setOnClickListener{
            viewModel.fetchNewMonster()
        }

        binding.SWActivityDelete.setOnClickListener{
            viewModel.deleteAll()
        }

    }

    override fun onStart() {
        super.onStart()
        viewModel.swMonstersLiveData.observe(this, swMonstersListObserver)
    }


    override fun onStop() {
        super.onStop()
        viewModel.swMonstersLiveData.removeObserver(swMonstersListObserver)
    }


    private fun onItemClick(objectDataSample: SWMonstersDomain, view: View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this, objectDataSample.monsterName, Toast.LENGTH_LONG).show()
    }
}

