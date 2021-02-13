package com.learning.catz.facts

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FactsViewModel(
    private val storage: FactsRepository
) : ViewModel(), LifecycleObserver {

    private val _facts = MutableLiveData<List<Fact>>()
    val facts: LiveData<List<Fact>> get() = _facts

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun init() {
        _loading.value = true
        viewModelScope.launch {
            requestCuriousities()
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    suspend fun requestCuriousities(){
        storage.facts.collect { _facts.value = it }
        _loading.value = false
    }
}