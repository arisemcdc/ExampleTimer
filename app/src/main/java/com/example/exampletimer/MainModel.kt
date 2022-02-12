package com.example.exampletimer

import android.os.CountDownTimer

class MainModel(private var timer: CountDownTimer) {


    fun data(timeMillis:Long): Int {

      timer = object : CountDownTimer(timeMillis, 1) {
          override fun onTick(millisUntilFinished: Long) {
              TODO("Not yet implemented")
          }

          override fun onFinish() {
              TODO("Not yet implemented")
          }

      }

      return R.string.formatted_time  //почему ругается на тип возвращаемых данных (Int, a не String?)
    }
}