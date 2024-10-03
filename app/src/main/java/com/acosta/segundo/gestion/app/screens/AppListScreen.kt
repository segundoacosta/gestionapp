package com.acosta.segundo.gestion.app.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.acosta.segundo.gestion.app.ui.components.AppForm
import com.acosta.segundo.gestion.app.ui.components.AppItem
import com.acosta.segundo.gestion.domain.model.App

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListScreen(
    onAppClick: (String) -> Unit,
    onOptimizeClick: () -> Unit,
    viewModel: AppListViewModel = hiltViewModel()
) {
    val apps by viewModel.apps.collectAsState()
    var showAddAppDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gestión App") },
                actions = {
                    IconButton(onClick = { showAddAppDialog = true }) {
                        Icon(Icons.Default.Add, contentDescription = "Añadir app")
                    }
                }
            )
        }
    ) { padding ->
        Button(onClick = { /*onOptimizeClick*/ }) {
            Text("Optimizar Apps")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(apps) { app ->
                AppItem(app = app, onClick = { onAppClick(app.id) })

            }
        }

        if (showAddAppDialog) {
            AppForm(
                onDismiss = { showAddAppDialog = false },
                onAppAdded = { app ->
                    viewModel.addApp(app)
                    showAddAppDialog = false
                }
            )
        }
    }
}