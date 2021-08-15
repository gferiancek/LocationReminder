package com.example.locationreminder.di

import com.example.locationreminder.cache.database.ReminderDao
import com.example.locationreminder.use_cases.reminders_edit.AddReminderUseCase
import com.example.locationreminder.use_cases.reminders_edit.EditReminderUseCase
import com.example.locationreminder.use_cases.reminders_list.GetAllRemindersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @ViewModelScoped
    @Provides
    fun provideAddReminder(reminderDao: ReminderDao): AddReminderUseCase {
        return AddReminderUseCase(reminderDao = reminderDao)
    }

    @ViewModelScoped
    @Provides
    fun provideGetAllReminders(reminderDao: ReminderDao): GetAllRemindersUseCase {
        return GetAllRemindersUseCase(remindersDao = reminderDao)
    }

    @ViewModelScoped
    @Provides
    fun provideEditReminder(reminderDao: ReminderDao): EditReminderUseCase {
        return EditReminderUseCase(reminderDao)
    }
}