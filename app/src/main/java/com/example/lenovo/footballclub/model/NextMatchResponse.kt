package com.example.lenovo.footballclub.model

import android.app.usage.UsageEvents
import com.google.gson.annotations.SerializedName

data class NextMatchResponse (
    @SerializedName("events") var nextmatch : List<NextMatch>
)