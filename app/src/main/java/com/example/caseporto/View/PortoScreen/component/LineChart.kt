package com.example.caseporto.View.PortoScreen.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.unit.dp
import com.example.caseporto.Model.monthData
import io.jetchart.common.animation.fadeInAnimation
import io.jetchart.line.Line
import io.jetchart.line.LineChart
import io.jetchart.line.Point
import io.jetchart.line.renderer.line.SolidLineDrawer
import io.jetchart.line.renderer.xaxis.LineXAxisDrawer
import io.jetchart.line.renderer.yaxis.LineYAxisWithValueDrawer


@Composable
fun LinesChart(
    monthList : List<Int>
){

    LineChart(
        lines = listOf(
            Line(points = points(10, monthList), lineDrawer = SolidLineDrawer(thickness = 8.dp, color = Blue))
        ),
        modifier = Modifier.fillMaxWidth().height(200.dp),
        animation = fadeInAnimation(3000),
        xAxisDrawer = LineXAxisDrawer(),
        yAxisDrawer = LineYAxisWithValueDrawer()
    )
}

@Composable
private fun points(count: Int, list: List<Int>): List<Point> {
    val valueOccurrences = mutableMapOf<Int, Int>()

    // Count occurrences
    for (value in list) {
        valueOccurrences[value] = valueOccurrences.getOrDefault(value, 0) + 1
    }

    // Create Point objects
    return valueOccurrences.map { (value, occurrences) ->
        Point(value.toFloat(), occurrences.toFloat().toString())
    }

}
//(1..count).map { Point(list, "it")