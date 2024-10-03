package com.acosta.segundo.gestion.app.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acosta.segundo.gestion.domain.model.App
import com.acosta.segundo.gestion.domain.usecase.GetAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailViewModel @Inject constructor(
    private val getAppUseCase: GetAppUseCase
) : ViewModel() {

    private val _app = MutableStateFlow<App?>(null)
    val app: StateFlow<App?> = _app

    fun loadApp(appId: String) {
        viewModelScope.launch {
            getAppUseCase(appId).collect { app ->
                _app.value = app
            }
        }
    }
}