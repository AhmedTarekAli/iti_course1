package com.a7med.iti_course1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.a7med.iti_course1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {

           Toast.makeText(this, "User name : ${binding.editTtext.text}", Toast.LENGTH_SHORT).show()
           Toast.makeText(this, "Password : ${binding.passwrdEd.text}", Toast.LENGTH_SHORT).show()
          //  Toast.makeText(this, "User name = ${binding.radio.}", Toast.LENGTH_SHORT).show()

           // Toast.makeText(this, "User3 name = ${binding.liner1}", Toast.LENGTH_SHORT).show()


        }


    }
}