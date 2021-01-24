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

    private val _startLoading = MutableLiveData<Unit>()
    val startLoading: LiveData<Unit> get() = _startLoading

    private val _stopLoading = MutableLiveData<Unit>()
    val stopLoading: LiveData<Unit> get() = _stopLoading

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun init() {
        _startLoading.value = Unit
        viewModelScope.launch {
            repository.facts.collect {
                _stopLoading.value = Unit
                _facts.value = it
            }
        }
    }
}