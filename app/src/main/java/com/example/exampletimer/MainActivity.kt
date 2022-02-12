package com.example.exampletimer

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.content.res.AppCompatResources
import com.example.exampletimer.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val presenter = MainPresenter(MainModel(timer))
    private lateinit var binding: ActivityMainBinding
    private var firstCount = 0
    private var secondCount = 0
    private var timer: CountDownTimer? = null
    private var isStarted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            bStart.setOnClickListener {
                if (!isStarted) {
                    startCountdownTimer(135000)
                }
                else {
                    stopTimer()
                }
            }
            addFirstPlayerPointButton.setOnClickListener {
                firstCount++
                firstPlayerPointsTextView.text = firstCount.toString()
            }
            addSecondPlayerPointButton.setOnClickListener {
                secondCount++
                secondPlayerPointsTextView.text = secondCount.toString()
            }

            removeFirstPlayerPointButton.setOnClickListener {
               if (firstCount <= 0) {
                   firstCount == 0
                   firstPlayerPointsTextView.text = firstCount.toString()
               }
                else {
                    firstCount--
                    firstPlayerPointsTextView.text = firstCount.toString()
               }
            }

            removeSecondPlayerPointButton.setOnClickListener {
                if (secondCount <= 0) {
                    secondCount == 0
                    secondPlayerPointsTextView.text = secondCount.toString()
                }
                else {
                    secondCount--
                    secondPlayerPointsTextView.text = secondCount.toString()
                }
            }
        }
    }

    private fun startCountdownTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1) {

            @SuppressLint("StringFormatMatches")
            override fun onTick(timeMillis: Long) {
                binding.tvTimer.text = getString(R.string.formatted_time,
                TimeUnit.MILLISECONDS.toMinutes(timeMillis) % 60  ,
                        TimeUnit.MILLISECONDS.toSeconds(timeMillis) % 60 )
                binding.tvTimer.setTextColor(Color.GREEN)
            }

            override fun onFinish() {
                binding.tvTimer.text = "Finish"
                isStarted = false
                binding.bStart.text = "Start"
                binding.tvTimer.setTextColor(Color.BLACK)
            }

        }.start()
        isStarted = true
        binding.bStart.text = "Stop"
    }

    private fun stopTimer() {
        timer?.cancel()
        isStarted = false
        binding.bStart.text = "Start"
        binding.tvTimer.text = "02:14"
        binding.tvTimer.setTextColor(Color.BLACK)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }

}