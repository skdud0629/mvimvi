package com.example.mvimvi.feature.random

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.orbitmvi.orbit.compose.collectAsState


@Composable
fun RandomScreen(
    MaxNumber: Int
) {
    val viewModel = RandomViewModel()
    val state = viewModel.collectAsState().value

    viewModel.getRandom(MaxNumber)
    Column {
        Text(text = "Random Number from 0 to " + state.MaxNumber + " is" + state.RandomNumber)
    }
}