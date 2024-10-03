package com.acosta.segundo.gestion.app.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acosta.segundo.gestion.domain.model.App
import com.acosta.segundo.gestion.domain.usecase.AddAppUseCase
import com.acosta.segundo.gestion.domain.usecase.GetAppsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val getAppsUseCase: GetAppsUseCase,
    private val addAppUseCase: AddAppUseCase
) : ViewModel() {

    private val _apps = MutableStateFlow<List<App>>(emptyList())
    val apps: StateFlow<List<App>> = _apps

    init {
        getApps()
    }

    private fun getApps() {
        getAppsUseCase().onEach { apps ->
            _apps.value = apps
        }.launchIn(viewModelScope)
    }

    fun addApp(app: App) {
        viewModelScope.launch {
            addAppUseCase(app)
        }
    }
}