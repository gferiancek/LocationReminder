package com.example.locationreminder.presentation.ui.reminders.reminders_edit

sealed class ReminderEditEvent {

    object AddNewReminderEvent : ReminderEditEvent()

    object EditCurrentReminderEvent : ReminderEditEvent()

    data class DeleteCurrentReminderEvent(val id: Long) : ReminderEditEvent()
}