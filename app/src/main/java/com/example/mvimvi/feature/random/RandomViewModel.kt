package com.example.mvimvi.feature.random

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class RandomViewModel: ContainerHost<RandomState, Unit>, ViewModel() {
    override val container: Container<RandomState, Unit> = container<RandomState, Unit>(RandomState())

    fun getRandom(maxNumber : Int ) = intent {
        reduce {
            state.copy(
                MaxNumber = maxNumber,
                RandomNumber = (0..maxNumber).random()
            )

        }
    }
}