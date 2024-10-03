package com.acosta.segundo.gestion.domain.usecase

import com.acosta.segundo.gestion.domain.model.App
import com.acosta.segundo.gestion.domain.repository.AppRepository
import javax.inject.Inject

class AddAppUseCase @Inject constructor(
    private val repository: AppRepository
) {
    suspend operator fun invoke(app: App) = repository.addApp(app)
}