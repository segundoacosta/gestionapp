package com.acosta.segundo.gestion.domain.usecase

import com.acosta.segundo.gestion.domain.model.App
import javax.inject.Inject

class OptimizeAppsUseCase @Inject constructor() {
    operator fun invoke(apps: List<App>): List<String> {
        val recommendations = mutableListOf<String>()

        // Implementar lógica de optimización aquí
        // Ejemplo simplificado:
        apps.forEach { app ->
            if (app.usage < 10 && app.resourceUsage > 50) {
                recommendations.add("Considere eliminar ${app.name} debido a su bajo uso y alto consumo de recursos.")
            }
        }

        return recommendations
    }
}