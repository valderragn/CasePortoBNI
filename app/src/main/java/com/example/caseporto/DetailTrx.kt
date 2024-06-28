package com.example.caseporto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.caseporto.Model.trxData
import com.example.caseporto.View.PortoScreen.DetailScreen
import com.example.caseporto.ui.theme.CasePortoTheme
import com.google.gson.Gson

class DetailTrx : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val protoDataString = intent.getStringExtra("trxData")
        val proto = Gson().fromJson(protoDataString, trxData::class.java)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CasePortoTheme {
                DetailScreen(proto)
            }
        }
    }
}
