package com.example.androiddebug

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

import kotlin.concurrent.thread

private const val  TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val helloTextView: TextView = findViewById(R.id.hello_world)
        //helloTextView.text = "Hello, debugging!"

        logging()
        division()
    }

    fun division() {
        val numerator = 60
        var denominator = 4

        thread(start = true){
            repeat(4) {
                Thread.sleep(3000)
                Log.d(TAG, "$denominator")
                Log.v(TAG, "${numerator / denominator}")
                runOnUiThread {
                    findViewById<TextView>(R.id.division_view).setText("${numerator / denominator}")
                    denominator--
                }
            }
        }
    }

    fun logging() {
        Log.v(TAG, "Hello world")
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }
}