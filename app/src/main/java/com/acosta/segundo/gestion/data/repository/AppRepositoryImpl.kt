package com.acosta.segundo.gestion.data.repository

import com.acosta.segundo.gestion.data.local.AppDao
import com.acosta.segundo.gestion.data.model.AppEntity
import com.acosta.segundo.gestion.domain.model.App
import com.acosta.segundo.gestion.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val appDao: AppDao
) : AppRepository {

    override fun getApps(): Flow<List<App>> {
        return appDao.getApps().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    override suspend fun addApp(app: App) {
        appDao.insertApp(AppEntity.fromDomainModel(app))
    }

    override suspend fun updateApp(app: App) {
        appDao.updateApp(AppEntity.fromDomainModel(app))
    }

    override suspend fun deleteApp(app: App) {
        appDao.deleteApp(AppEntity.fromDomainModel(app))
    }

    override suspend fun getAppById(id: String): Flow<App?> {
        TODO("Not yet implemented")
    }
}