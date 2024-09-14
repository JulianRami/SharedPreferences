package com.example.sharedpreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "IncrementAppPrefs"
    private val VALUE_KEY = "valueKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)

        val valueTextView: TextView = findViewById(R.id.valueTextView)
        val currentValue = getCurrentValue()
        valueTextView.text = currentValue.toString()

        saveValue(currentValue + 1)
    }

    private fun getCurrentValue(): Int {
        return sharedPreferences.getInt(VALUE_KEY, 0)
    }

    private fun saveValue(value: Int) {
        with(sharedPreferences.edit()) {
            putInt(VALUE_KEY, value)
            apply()
        }
    }
}