package com.udacity.project4.domain.utils

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.udacity.project4.cache.database.ReminderDao
import javax.inject.Inject

class GeofenceWorkerFactory @Inject constructor(
    private val reminderDao: ReminderDao
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker {
        return GeofenceWorker(appContext, workerParameters, reminderDao)
    }
}