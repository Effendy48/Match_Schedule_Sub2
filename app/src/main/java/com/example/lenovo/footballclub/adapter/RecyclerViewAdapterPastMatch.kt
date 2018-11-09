package com.example.lenovo.footballclub.adapter

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.lenovo.footballclub.R
import com.example.lenovo.footballclub.model.TeamResult
import org.jetbrains.anko.*

class RecyclerViewAdapterPastMatch (private val teamResult: List<TeamResult>)
    :RecyclerView.Adapter<TeamResultViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamResultViewHolder {
        return TeamResultViewHolder(UIANKO().createView(AnkoContext.create(parent.context,parent)))
    }

    override fun getItemCount(): Int = teamResult.size

    override fun onBindViewHolder(holder: TeamResultViewHolder, position : Int) {
        holder.bindItem(teamResult[position])

    }
}
class UIANKO : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL

                linearLayout {
                    gravity = Gravity.CENTER_HORIZONTAL
                    orientation = LinearLayout.HORIZONTAL

                    textView("2") {
                        id = R.id.tv_home_team_past
                        textSize = 30f
                    }.lparams(width = wrapContent, height = wrapContent) {
                        margin = dip(10)
                    }
                    textView("-") {
                        textSize = 30f
                    }.lparams(width = wrapContent, height = wrapContent) {
                        margin = dip(10)
                    }
                    textView("2") {
                        id = R.id.tv_away_team_past
                        textSize = 30f
                    }.lparams(width = wrapContent, height = wrapContent) {
                        margin = dip(10)
                    }

                }
            }
        }
    }

}

class TeamResultViewHolder(view : View):RecyclerView.ViewHolder(view) {
    private val tv_home_team_past : TextView = view.find(R.id.tv_home_team_past)
    private val tv_away_team_past : TextView = view.find(R.id.tv_away_team_past)

    fun bindItem(teamResult: TeamResult){
        tv_home_team_past.text = teamResult.teamHome
        tv_away_team_past.text = teamResult.teamAway
    }

}
