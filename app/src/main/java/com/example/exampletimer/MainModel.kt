package com.example.exampletimer

import android.os.CountDownTimer
import android.provider.Settings.Global.getString
import java.util.concurrent.TimeUnit

class MainModel(private var timer: CountDownTimer) {


    fun data(timeMillis:Long): Int {

      timer = object : CountDownTimer(timeMillis, 1) {
          override fun onTick(millisUntilFinished: Long) {
              var text = getString(R.string.formatted_time,
              TimeUnit.MILLISECONDS.toMinutes(timeMillis) % 60 ,
              TimeUnit.MILLISECONDS.toSeconds(timeMillis) % 60)

          }

          override fun onFinish() {
              val text = "Finish"
          }

      }

      return R.string.formatted_time  //почему ругается на тип возвращаемых данных (Int, a не String?)
    }
}