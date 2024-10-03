package com.acosta.segundo.gestion.domain.repository

import com.acosta.segundo.gestion.domain.model.App
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getApps(): Flow<List<App>>
    suspend fun addApp(app: App)
    suspend fun updateApp(app: App)
    suspend fun deleteApp(app: App)
    suspend fun getAppById(id: String): Flow<App?>
}