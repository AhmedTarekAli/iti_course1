package com.a7med.iti_course1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.a7med.iti_course1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener {
            val username = binding.editTtext.text.toString()
            var chek = ""
            var gender = ""
            //Sport
            if (binding.chekFoot.isChecked) {
                chek += "football"
            }
            if (binding.chekBasket.isChecked) {
                chek += "basketball"
            }
            if (binding.chekHand.isChecked) {
                chek += "handball"
            }
            //Gender
            if (binding.radioFe.isChecked) {
                gender += "Female"
            } else {
                gender += "Male"
            }
            //Tost Message
            Toast.makeText(this, "UserName IS $username ", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, " Sport Is  $chek ", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, " Gender Is $gender", Toast.LENGTH_SHORT).show()


            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("UserName", binding.editTtext.text.toString())
            startActivityForResult(intent, 1)

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            Toast.makeText(
                this,
                data?.extras?.getString("Loginwith") ?: "error",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

