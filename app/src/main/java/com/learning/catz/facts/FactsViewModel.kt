package com.learning.catz.facts

import androidx.lifecycle.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FactsViewModel @Inject constructor(
    private val repository: FactsRepository
) : ViewModel(), LifecycleObserver {

    private val _facts = MutableLiveData<List<Fact>>()
    val facts: LiveData<List<Fact>> get() = _facts

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun init() {
        _loading.value = true
        viewModelScope.launch {
            _loading.value = false
            repository.facts.collect { _facts.value = it }
        }
    }
}