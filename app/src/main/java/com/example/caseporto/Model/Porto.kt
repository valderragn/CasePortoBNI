package com.example.caseporto.Model

import java.time.Month

data class Porto(
    val type: String,
    val data: Any
)

data class monthData(
    val month: List<Int>
)

data class trxData(
    val label: String,
    val percentage: String,
    val data: List<dtlTrxData>,
)

data class dtlTrxData(
    val trx_date: String,
    val nominal: Int
)
