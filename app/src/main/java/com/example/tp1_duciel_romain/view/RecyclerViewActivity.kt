package com.example.tp1_duciel_romain.view

import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.AbsListView.RecyclerListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1_duciel_romain.databinding.ActivityRecyclerViewBinding
import com.example.tp1_duciel_romain.view.model.MyObjectForRecyclerView
import com.example.tp1_duciel_romain.view.model.ObjectDataFooterSample
import com.example.tp1_duciel_romain.view.model.ObjectDataHeaderSample
import com.example.tp1_duciel_romain.view.model.RecyclerViewData

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: NBATeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the instance of adapter
        adapter = NBATeamAdapter { item, view ->
            onItemClick(item, view)
        }

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

        // Generate data and give it to adapter
        adapter.submitList(generateFakeData())
    }

    private fun onItemClick(objectDataSample: RecyclerViewData, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this, objectDataSample.teamName, Toast.LENGTH_LONG).show()
    }


    private fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()

        mutableListOf(
            RecyclerViewData("Boston Celtics", "Est"),
            RecyclerViewData("Milwaukee Bucks", "Est"),
            RecyclerViewData("Cleveland Cavalier", "Est"),
            RecyclerViewData("Brooklyn Nets", "Est"),
            RecyclerViewData("Philadelphia 76ers", "Est"),
            RecyclerViewData("Atlanta Hawks", "Est"),
            RecyclerViewData("Indiana Pacers", "Est"),
            RecyclerViewData("New York Knicks", "Est"),
            RecyclerViewData("Toronto Raptors", "Est"),
            RecyclerViewData("Miami Heat", "Est"),
            RecyclerViewData("Chicago Bulls", "Est"),
            RecyclerViewData("Washington Wizards", "Est"),
            RecyclerViewData("Orlando Magic", "Est"),
            RecyclerViewData("Charlotte Hornets", "Est"),
            RecyclerViewData("Detroit Pistons", "Est"),
            RecyclerViewData("New Orleans Pelicans", "Ouest"),
            RecyclerViewData("Memphis Grizzlies", "Ouest"),
            RecyclerViewData("Denver Nuggets", "Ouest"),
            RecyclerViewData("Phoenix Suns", "Ouest"),
            RecyclerViewData("Sacramento Kings", "Ouest"),
            RecyclerViewData("Portland Trail Blazers", "Ouest"),
            RecyclerViewData("Los Angeles Clippers", "Ouest"),
            RecyclerViewData("Golden State Warriors", "Ouest"),
            RecyclerViewData("Utah Jazz", "Ouest"),
            RecyclerViewData("Dallas Mavericks", "Ouest"),
            RecyclerViewData("Minessota Timberwolves", "Ouest"),
            RecyclerViewData("Los Angeles Lakers", "Ouest"),
            RecyclerViewData("Oklahoma City Thunder", "Ouest"),
            RecyclerViewData("San Antonio Spurs", "Ouest"),
            RecyclerViewData("Houston Rockets", "Ouest"),
        ).groupBy { it.conference }
            .forEach { (conferenceResult, items) ->
                result.add(ObjectDataHeaderSample("Conférence $conferenceResult"))
                result.addAll(items)
                result.add(ObjectDataFooterSample("Equipes: ${items.size}"))
            }
        return result
    }

}