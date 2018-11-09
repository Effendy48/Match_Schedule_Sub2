package com.example.lenovo.footballclub

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.lenovo.footballclub.adapter.RecyclerViewAdapterPastMatch
import com.example.lenovo.footballclub.api.ApiRepository
import com.example.lenovo.footballclub.model.TeamResult
import com.example.lenovo.footballclub.presenter.MainPresenter
import com.example.lenovo.footballclub.util.invisible
import com.example.lenovo.footballclub.util.visible
import com.example.lenovo.footballclub.view.MainView
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FragmentPast : Fragment(),MainView {

    private lateinit var listResultTeam : RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh : SwipeRefreshLayout
    private var teamResult : MutableList<TeamResult> = mutableListOf()
    private lateinit var presenter : MainPresenter
    private lateinit var rv_adapter: RecyclerViewAdapterPastMatch
    private lateinit var id : String



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return UI_PAST_MATCH().createView(AnkoContext.create(inflater.context, this, false))
     }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this,request,gson)

        rv_adapter = RecyclerViewAdapterPastMatch(teamResult)

        presenter.getResultMatch()
        listResultTeam = view.find(R.id.rv_match_result)
        progressBar = view.find(R.id.progress_bar)

        listResultTeam.layoutManager = LinearLayoutManager(ctx)
        listResultTeam.adapter = rv_adapter

        swipeRefresh = view.find(R.id.swipeRefresh)
        swipeRefresh.onRefresh {
            presenter.getResultMatch()
        }

    }
    companion object {
        fun newInstance(): FragmentPast = FragmentPast()
    }
    class UI_PAST_MATCH : AnkoComponent<FragmentPast>{
        @SuppressLint("ResourceAsColor")
        override fun createView(ui: AnkoContext<FragmentPast>) = with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                orientation = LinearLayout.VERTICAL
                topPadding = dip(16)
                leftPadding = dip(16)
                rightPadding = dip(16)

                swipeRefreshLayout {
                    setColorSchemeColors(android.support.v7.appcompat.R.attr.colorAccent,
                            android.R.color.holo_green_light,
                            android.R.color.holo_orange_light,
                            android.R.color.holo_red_light)
                    id = R.id.swipeRefresh
                    relativeLayout {
                        lparams (width = matchParent, height = wrapContent)

                        recyclerView {
                            id = R.id.rv_match_result
                            lparams (width = matchParent, height = wrapContent)
                            layoutManager = LinearLayoutManager(ctx)
                        }
                        progressBar {
                            id = R.id.progress_bar
                        }.lparams{
                            centerHorizontally()
                        }
                    }
                }
            }

        }

    }
    override fun showLoading() {
        progressBar = find(R.id.progress_bar)
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar = find(R.id.progress_bar)
        progressBar.invisible()
    }

    override fun showTeamResultList(data: List<TeamResult>) {
        swipeRefresh.isRefreshing = false
        teamResult.clear()
        teamResult.addAll(data)
        rv_adapter.notifyDataSetChanged()
    }
}

