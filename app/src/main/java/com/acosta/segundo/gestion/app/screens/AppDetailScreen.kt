package com.acosta.segundo.gestion.app.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDetailScreen(
    appId: String?,
    viewModel: AppDetailViewModel = hiltViewModel()
) {
    val app by viewModel.app.collectAsState()

    LaunchedEffect(appId) {
        appId?.let { viewModel.loadApp(it) }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(app?.name ?: "Detalles de la App") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            app?.let { app ->
                Text("Nombre: ${app.name}", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Uso: ${app.usage}%")
                Text("Recursos: ${app.resourceUsage}%")
                Text("Última vez usado: ${app.lastUsed}")
                Text("Versión: ${app.version}")
            }
        }
    }
}