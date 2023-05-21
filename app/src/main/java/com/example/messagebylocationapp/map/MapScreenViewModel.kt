package com.example.messagebylocationapp.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MapScreenViewModel: ViewModel(){
    private val _testFlow : MutableStateFlow<Test> = MutableStateFlow(Test())
    val testFlow = _testFlow.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                _testFlow.update { it.copy() }
            }
        }
    }

    fun a (number: Int, string: String) {}

    fun b () {}
}

data class Test(
    var test: Int = 3
)