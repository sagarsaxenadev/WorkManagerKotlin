package com.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.Exception


class Task(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {

        try {
            var n=0
          while (n<10){
              Log.i("Task ","$n")
              n++
              // let's delay the work to see the work in log
              runBlocking {
                  delay(1000)

              }
          }

        }
        catch (exception:Exception){
            Log.e("exception ","${exception.message}")
            return Result.failure()


        }

        return Result.success()


    }


}