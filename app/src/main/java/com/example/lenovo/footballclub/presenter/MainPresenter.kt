package com.example.lenovo.footballclub.presenter

import com.example.lenovo.footballclub.api.ApiRepository
import com.example.lenovo.footballclub.model.TeamResultResponse
import com.example.lenovo.footballclub.view.MainView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (
    private val View : MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
){
    fun getResultMatch() {
        View.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(ApiRepository.TheSportDBApi. getResultMatch()), TeamResultResponse::class.java)

            uiThread {
                View.hideLoading()
                View.showTeamResultList(data.teamResult)
            }
        }
    }
}
