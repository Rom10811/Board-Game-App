package com.example.tp1_duciel_romain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp1_duciel_romain.repository.NBATeamRepository
import com.example.tp1_duciel_romain.view.model.MyObjectForRecyclerView
import com.example.tp1_duciel_romain.view.model.ObjectDataFooterSample
import com.example.tp1_duciel_romain.view.model.ObjectDataHeaderSample
import com.example.tp1_duciel_romain.view.model.RecyclerViewData

class NBATeamViewModel: ViewModel() {
    private val _nbaTeamList = MutableLiveData<List<MyObjectForRecyclerView>>()
    private val nbaTeamRepository:NBATeamRepository by lazy { NBATeamRepository() }
    val nbaTeamList:LiveData<List<MyObjectForRecyclerView>>get() = _nbaTeamList

    init {
        _nbaTeamList.postValue(nbaTeamRepository.generateFakeData())
    }
}