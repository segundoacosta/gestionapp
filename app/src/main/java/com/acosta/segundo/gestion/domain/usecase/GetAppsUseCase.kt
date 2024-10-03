package com.acosta.segundo.gestion.domain.usecase

import com.acosta.segundo.gestion.domain.model.App
import com.acosta.segundo.gestion.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppsUseCase @Inject constructor(
    private val repository: AppRepository
) {
    operator fun invoke(): Flow<List<App>> = repository.getApps()
}