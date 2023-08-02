package com.a7med.iti_course1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a7med.iti_course1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     binding=ActivityMainBinding.inflate(layoutInflater)

    }
}