package com.acosta.segundo.gestion.domain.model

import java.util.Date

data class App(
    val id: String,
    val name: String,
    val usage: Float,
    val resourceUsage: Float,
    val lastUsed: Date,
    val version: String
)