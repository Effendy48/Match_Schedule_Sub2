package com.example.lenovo.footballclub.view

import com.example.lenovo.footballclub.model.TeamResult

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamResultList(data : List<TeamResult>)
}