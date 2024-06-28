package com.example.caseporto.View.PortoScreen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.caseporto.Model.Porto
import com.example.caseporto.Model.monthData
import com.example.caseporto.Model.trxData
import com.example.caseporto.View.PortoScreen.component.DataCard
import com.example.caseporto.View.PortoScreen.component.DonutChart
import com.example.caseporto.View.PortoScreen.component.LinesChart
import com.example.caseporto.View.PortoScreen.component.MyTopAppbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun PortoScreen(
    porto: List<Porto>,
    context: Context
) {
    PortoContent(porto = porto, context = context)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PortoContent(
    porto: List<Porto>,
    context: Context
){

    var chartDonut : List<trxData> = emptyList()
    var chartLine : monthData = monthData(month = emptyList())
    var chartLines: List<Int>

    porto.forEach { item ->

        when (item.type) {
            "donutChart" -> {
                val trxDataList = item.data

                val gson = Gson()
                val json = gson.toJson(trxDataList) // Convert trxDataList to JSON string
                val type = object : TypeToken<List<trxData>>() {}.type
                chartDonut = gson.fromJson(json, type) // Convert JSON string to List<trxData>
            }
            "lineChart" -> {
                val monthDataMap = item.data as Map<String, List<Int>>
                val monthDataList = monthDataMap["month"] ?: emptyList()
                chartLine = monthData(month = monthDataList)

            }
        }
    }

    chartLines = chartLine.month

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppbar(tittle = "Promos")
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 100.dp)
        ) {
                DonutChart(chartDonut)
                LinesChart(chartLines)
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .height(1000.dp)
                    .offset(y = 30.dp)
                    .padding(horizontal = 20.dp)
                ) {
                    items(chartDonut) { them ->
                        DataCard(them, context)
                    }
                }

        }
    }
}