package com.acosta.segundo.gestion.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.acosta.segundo.gestion.domain.model.App
import java.util.Date

@Entity(tableName = "apps")
data class AppEntity(
    @PrimaryKey val id: String,
    val name: String,
    val usage: Float,
    val resourceUsage: Float,
    val lastUsed: Date,
    val version: String
) {
    companion object {
        fun fromDomainModel(app: App): AppEntity {
            return AppEntity(
                id = app.id,
                name = app.name,
                usage = app.usage,
                resourceUsage = app.resourceUsage,
                lastUsed = app.lastUsed,
                version = app.version
            )
        }
    }

    fun toDomainModel(): App {
        return App(
            id = id,
            name = name,
            usage = usage,
            resourceUsage = resourceUsage,
            lastUsed = lastUsed,
            version = version
        )
    }
}