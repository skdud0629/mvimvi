package com.example.mvimvi.feature.main

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel: ContainerHost<MainState, MainSideEffect>, ViewModel() {
    override val container = container<MainState, MainSideEffect>(MainState())

    fun toast() = intent {
        postSideEffect(MainSideEffect.ShowToast("Toast"))
    }

    fun count() = intent {
        reduce {
            state.copy(count = state.count + 1)
        }
    }

    fun random() = intent {
        postSideEffect(MainSideEffect.NavigateToRandomScreen(state.count))
    }

}