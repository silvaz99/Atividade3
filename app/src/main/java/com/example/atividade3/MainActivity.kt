package com.example.atividade3

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {
    private var sensorManager : SensorManager? = null
    private var accelerometer: Sensor? = null
    private var light : Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        light = sensorManager?.getDefaultSensor(Sensor.TYPE_LIGHT)

        sensorManager!!.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager!!.registerListener(SensorLight(), light, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent) {
        //Log.d(
        //    "Atividade 3: ",
        //    "sensorChanged X: " + event.values[0] + " Y: " + event.values[1] + " Z: " + event.values[2]
        //)
        if(event.values[0] > 10 || event.values[1] > 10 || event.values[2] > 10) {
            setContentView(R.layout.mensagem)
            //sensorManager.unregisterListener(this)
        } else {
            setContentView(R.layout.activity_main)
            val editText: TextView = findViewById(R.id.textView)
            val editText2: TextView = findViewById(R.id.textView2)
            val editText3: TextView = findViewById(R.id.textView3)
            editText.text = "X: " + event.values[0].toString()
            editText2.text = "Y: " + event.values[1].toString()
            editText3.text = "Z: " + event.values[2].toString()
        }

    }

    override fun onAccuracyChanged(p0: android.hardware.Sensor?, p1: Int) {

    }
}