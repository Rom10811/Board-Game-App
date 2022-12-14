package com.example.tp1_duciel_romain.viewmodel

import androidx.lifecycle.*
import com.example.tp1_duciel_romain.repository.NBATeamRepository
import com.example.tp1_duciel_romain.model.MyObjectForRecyclerView
import com.example.tp1_duciel_romain.model.ObjectDataFooterSample
import com.example.tp1_duciel_romain.model.ObjectDataHeaderSample
import com.example.tp1_duciel_romain.model.RecyclerViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NBATeamViewModel: ViewModel() {
    private val _nbaTeamList = MutableLiveData<List<MyObjectForRecyclerView>>()
    private val nbaTeamRepository:NBATeamRepository by lazy { NBATeamRepository() }
    val nbaTeamList:LiveData<List<MyObjectForRecyclerView>> = nbaTeamRepository.selectAllNBATeam().map { list ->
        list.toMyObjectForRecyclerView()
    }

    fun insertNBATeam(teamName: String, teamConference: String, teamRank: Int, teamLogo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            nbaTeamRepository.insertNBATeam(
                RecyclerViewData(teamName, teamConference, teamRank, teamLogo),
            )
        }
    }


    fun deleteAllNBATeam() {
        viewModelScope.launch(Dispatchers.IO) {
            nbaTeamRepository.deleteAllNBATeam()
        }
    }

    private fun List<RecyclerViewData>.toMyObjectForRecyclerView(): List<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()


        groupBy { it.teamConference }
            .forEach { (conferenceResult, items) ->
                result.add(ObjectDataHeaderSample("Conférence $conferenceResult"))
                result.addAll(items)
                result.add(ObjectDataFooterSample("Equipes: ${items.size}"))
            }
        return result
    }


    init {
        _nbaTeamList.postValue(nbaTeamRepository.generateFakeData())
    }
}