package com.acosta.segundo.gestion.app.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acosta.segundo.gestion.domain.model.App

@Composable
fun AppItem(app: App, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = app.name, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Uso: ${app.usage}%")
            Text(text = "Recursos: ${app.resourceUsage}%")
            Text(text = "Versión: ${app.version}")
        }
    }
}