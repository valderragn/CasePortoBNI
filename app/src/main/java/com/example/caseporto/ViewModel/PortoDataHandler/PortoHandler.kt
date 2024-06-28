package com.example.caseporto.ViewModel.PortoDataHandler

import android.content.Context
import android.content.Intent
import com.example.caseporto.DetailTrx
import com.example.caseporto.Model.trxData
import com.google.gson.Gson

fun ondataClicked(trxData: trxData, context: Context){
    val portHand = PortoHandler()
    portHand.ondataClicked(trxData, context)

}

class PortoHandler {
    fun ondataClicked(trxData: trxData, context: Context) {
        val i = Intent(context, DetailTrx::class.java)
        i.putExtra("trxData", Gson().toJson(trxData)) // Pass the trxData object as an extra
        context.startActivity(i)
    }
}
