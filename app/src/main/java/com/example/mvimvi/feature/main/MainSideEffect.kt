package com.example.mvimvi.feature.main

sealed class MainSideEffect {
    data class ShowToast(val string: String) : MainSideEffect()
    data class NavigateToRandomScreen(var random: Int): MainSideEffect()
}
