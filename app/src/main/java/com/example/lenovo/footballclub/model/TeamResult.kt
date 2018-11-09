package com.example.lenovo.footballclub.model
import com.google.gson.annotations.SerializedName

data class TeamResult(
    @SerializedName("strHomeTeam")
    var teamHome : String? = null,
    @SerializedName("strAwayTeam")
    var teamAway : String? = null,
    @SerializedName("intHomeScore")
    var homeScore : String? = null,
    @SerializedName("intAwayScore")
    var awayScore : String? = null,
    @SerializedName("dateEvent")
    var dateEvent : String? = null
)

