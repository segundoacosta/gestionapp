package com.acosta.segundo.gestion.app.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acosta.segundo.gestion.domain.model.App
import java.util.*

@Composable
fun AppForm(
    onDismiss: () -> Unit,
    onAppAdded: (App) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var usage by remember { mutableStateOf("") }
    var resourceUsage by remember { mutableStateOf("") }
    var version by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Añadir nueva aplicación") },
        text = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nombre de la app") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = usage,
                    onValueChange = { usage = it },
                    label = { Text("Uso (%)") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = resourceUsage,
                    onValueChange = { resourceUsage = it },
                    label = { Text("Uso de recursos (%)") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = version,
                    onValueChange = { version = it },
                    label = { Text("Versión") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val newApp = App(
                        id = UUID.randomUUID().toString(),
                        name = name,
                        usage = usage.toFloatOrNull() ?: 0f,
                        resourceUsage = resourceUsage.toFloatOrNull() ?: 0f,
                        lastUsed = Date(),
                        version = version
                    )
                    onAppAdded(newApp)
                }
            ) {
                Text("Añadir")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}