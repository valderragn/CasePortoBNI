package com.example.caseporto.ViewModel.PortoDataHandler

import android.content.Context
import android.util.Log
import com.example.caseporto.Model.Porto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.IOException

fun loadJson(context: Context):List<Porto>{
    var listData : List<Porto> = emptyList()
    try {
        val dataHand = LocalDataHandler()
        val stringJson = dataHand.loadJson(context)

        val listType = object : TypeToken<List<Porto>>() {}.type
        listData = Gson().fromJson(stringJson, listType)
        Log.d("ERRLOAD", "filledloadJson: " + listData)
    }catch (e: Exception){
        Log.d("ERRLOAD", "loadJson: " + e)
    }
    return listData
}

class LocalDataHandler{
    fun loadJson(context: Context):String{
        var json : String

        try {
            val inputStream = context.assets.open("porto.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        }catch (e: IOException){
            e.printStackTrace()
            json = ""
        }
        return json
    }
}
