package com.example.atividade3

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SensorLight : AppCompatActivity(), SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.light_sensor)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        //setContentView(R.layout.light_sensor)
        val lightTextView : TextView = findViewById(R.id.textView6)
        Log.d("Light: ", event?.values?.get(0).toString())
        if (event != null) {
            lightTextView.text = "Luz: " + event.values[0].toString()
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

}