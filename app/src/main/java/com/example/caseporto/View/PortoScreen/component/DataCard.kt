package com.example.caseporto.View.PortoScreen.component

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caseporto.Model.trxData
import com.example.caseporto.ViewModel.PortoDataHandler.ondataClicked

@Composable
fun DataCard(
    trxData: trxData,
    context: Context
){
    Card(
        onClick = {ondataClicked(trxData, context)},
        modifier = Modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(contentColor = Color.Black)
    ) {
        Column(
            modifier= Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = trxData.label,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}