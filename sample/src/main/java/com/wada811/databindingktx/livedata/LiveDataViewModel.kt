package com.wada811.databindingktx.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LiveDataViewModel : ViewModel() {
    private val number = MutableLiveData<Int>().also {
        it.value = 0
    }
    val text: LiveData<String> = MediatorLiveData<String>().also {
        it.addSource(number) { value ->
            it.value = "$value"
        }
    }

    fun minus() {
        number.value = number.value?.minus(1)
    }

    fun plus() {
        number.value = number.value?.plus(1)
    }
}