package com.example.caseporto.View.PortoScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caseporto.DetailTrx
import com.example.caseporto.Model.dtlTrxData
import com.example.caseporto.Model.trxData
import com.example.caseporto.View.PortoScreen.component.DataCard
import com.example.caseporto.View.PortoScreen.component.DetailCard
import com.example.caseporto.View.PortoScreen.component.MyTopAppbar


@Composable
internal fun DetailScreen(
    trxData: trxData
) {
    DetailContent(trxData)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailContent(
    trxData: trxData
){
    val theLine : List<dtlTrxData> = trxData.data

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppbar(tittle = "Promos")
        }
    ){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 100.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = trxData.label,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .height(1000.dp)
                .offset(y = 30.dp)
                .padding(horizontal = 20.dp)
            ) {
                items(theLine) { them ->
                    DetailCard(them)
                }
            }
        }

    }
}
