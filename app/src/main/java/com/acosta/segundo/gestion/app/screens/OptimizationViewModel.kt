package com.acosta.segundo.gestion.app.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acosta.segundo.gestion.domain.usecase.GetAppsUseCase
import com.acosta.segundo.gestion.domain.usecase.OptimizeAppsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OptimizationViewModel @Inject constructor(
    private val getAppsUseCase: GetAppsUseCase,
    private val optimizeAppsUseCase: OptimizeAppsUseCase
) : ViewModel() {

    private val _recommendations = MutableStateFlow<List<String>>(emptyList())
    val recommendations: StateFlow<List<String>> = _recommendations

    fun optimizeApps() {
        viewModelScope.launch {
            val apps = getAppsUseCase().first()
            _recommendations.value = optimizeAppsUseCase(apps)
        }
    }
}