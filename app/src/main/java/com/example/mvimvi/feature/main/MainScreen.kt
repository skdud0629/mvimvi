package com.example.mvimvi.feature.main

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
    randomNum: (randomNumber: Int) -> Unit = {}
) {
    val context = LocalContext.current
    val state = viewModel.collectAsState().value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        viewModel.collectSideEffect {
            when (it) {
                is MainSideEffect.ShowToast -> {
                    Toast.makeText(
                        context, it.string, Toast.LENGTH_SHORT
                    ).show()
                }

                is MainSideEffect.NavigateToRandomScreen -> {
                    randomNum(it.random)
                }
            }
        }

        Text(text = "Count: ${state.count}")


        Button(
            modifier = Modifier.width(200.dp),
            onClick = { viewModel.toast() }) {
            Text(text = "Toast")
        }
        Button(
            modifier = Modifier.width(200.dp),
            onClick = { viewModel.count() }) {
            Text(text = "Count")
        }
        Button(
            modifier = Modifier.width(200.dp),
            onClick = { viewModel.random() }) {
            Text(text = "Random")
        }


    }

}




