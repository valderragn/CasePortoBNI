package com.example.caseporto.View.PortoScreen.component

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.unit.dp
import com.example.caseporto.Model.trxData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.jetchart.common.animation.fadeInAnimation
import io.jetchart.pie.PieChart
import io.jetchart.pie.Pies
import io.jetchart.pie.Slice
import io.jetchart.pie.renderer.FilledSliceDrawer


@Composable
fun DonutChart(
    dataTD : List<trxData>
){
    val gson = Gson()
    val json = gson.toJson(dataTD)// Your JSON data
    val trxDataList: List<trxData> = gson.fromJson(json, object : TypeToken<List<trxData>>() {}.type)

    val slices : List<Slice> = trxDataList.map{
        trx -> Slice(trx.percentage.toFloat(), getColorForTrx(trx.label))
    }

    PieChart(pies = Pies(slices),
        modifier = Modifier.height(200.dp),
        animation = fadeInAnimation(4000),
        sliceDrawer = FilledSliceDrawer(thickness = 20f)
    )
}

private fun getColorForTrx(label: String): Color {
    return when (label) {
        "Topup Gopay" -> Green
        "Tarik Tunai" -> Red
        "QRIS Payment" -> Yellow
        else -> Color.Gray
    }
}