package com.acosta.segundo.gestion.di


import android.content.Context
import androidx.room.Room
import com.acosta.segundo.gestion.data.local.AppDao
import com.acosta.segundo.gestion.data.local.AppDatabase
import com.acosta.segundo.gestion.data.repository.AppRepositoryImpl
import com.acosta.segundo.gestion.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAppDao(database: AppDatabase) = database.appDao()

    @Provides
    @Singleton
    fun provideAppRepository(appDao: AppDao): AppRepository {
        return AppRepositoryImpl(appDao)
    }
}