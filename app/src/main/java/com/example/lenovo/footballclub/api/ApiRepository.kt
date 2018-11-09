package com.example.lenovo.footballclub.api

import android.net.Uri
import com.example.lenovo.footballclub.BuildConfig
import java.net.URL

class ApiRepository{
    object TheSportDBApi {
        fun getResultMatch():String{
            return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                    .appendPath("api")
                    .appendPath("v1")
                    .appendPath("json")
                    .appendPath(BuildConfig.API_KEY)
                    .appendPath("eventspastleague.php")
                    .appendQueryParameter("id","4328")
                    .build()
                    .toString()
        }
        fun getNextMatch(id : String?):String{
            return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                    .appendPath("api")
                    .appendPath("v1")
                    .appendPath("json")
                    .appendPath(BuildConfig.API_KEY)
                    .appendPath("eventsnextleague.php")
                    .appendQueryParameter("id",id)
                    .build()
                    .toString()
        }

    }

    fun doRequest(url : String): String{
       return URL(url).readText()
    }
}
