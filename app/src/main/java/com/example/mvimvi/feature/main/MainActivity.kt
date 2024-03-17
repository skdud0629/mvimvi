package com.example.mvimvi.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mvimvi.feature.RandomScreenNavigator
import com.example.mvimvi.ui.theme.MvimviTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvimviTheme {
                RandomScreenNavigator()
            }
        }
    }
}

