package com.udacity.project4.di

import android.content.Context
import androidx.room.Room
import com.udacity.project4.data.cache.database.ReminderDao
import com.udacity.project4.data.cache.database.ReminderDatabase
import com.udacity.project4.data.repository.ReminderRepository
import com.udacity.project4.data.repository.ReminderRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context): ReminderDatabase {
        return Room
            .databaseBuilder(
                app,
                ReminderDatabase::class.java,
                ReminderDatabase.DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideReminderDao(database: ReminderDatabase): ReminderDao {
        return database.reminderDao()
    }

    @Singleton
    @Provides
    fun provideReminderRepository(dao: ReminderDao): ReminderRepository {
        return ReminderRepositoryImpl(dao)
    }
}