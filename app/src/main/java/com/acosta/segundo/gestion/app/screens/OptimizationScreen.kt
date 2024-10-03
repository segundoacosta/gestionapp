package com.acosta.segundo.gestion.app.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptimizationScreen(
    viewModel: OptimizationViewModel = hiltViewModel()
) {
    val recommendations by viewModel.recommendations.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Optimización de Apps") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Button(
                onClick = { viewModel.optimizeApps() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Optimizar Apps")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(recommendations) { recommendation ->
                    Text(recommendation)
                    Divider()
                }
            }
        }
    }
}