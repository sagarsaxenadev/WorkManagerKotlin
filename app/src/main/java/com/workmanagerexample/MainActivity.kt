package com.workmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraint = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED).build()

        // one time work request
        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<Task>()
                .setConstraints(constraint)
                .build()
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)



        // periodic work request, minimum repeat interval can be 15 mini.
        val periodicWorkRequest = PeriodicWorkRequest.Builder(Task::class.java,15, TimeUnit.MINUTES)
                .setConstraints(constraint)
                .build()
        WorkManager.getInstance(this).enqueue(periodicWorkRequest)


    }
}