package com.udacity.project4.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.udacity.project4.data.cache.model.ReminderEntity

@Database(entities = [ReminderEntity::class], version = 1, exportSchema = false)
abstract class ReminderDatabase : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao

    companion object {
        const val DATABASE_NAME = "reminder_db"
    }
}