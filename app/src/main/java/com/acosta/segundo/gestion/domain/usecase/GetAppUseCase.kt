package com.acosta.segundo.gestion.domain.usecase

import com.acosta.segundo.gestion.domain.model.App
import com.acosta.segundo.gestion.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppUseCase @Inject constructor(
    private val repository: AppRepository
) {
    suspend operator fun invoke(appId: String): Flow<App?> = repository.getAppById(appId)
}