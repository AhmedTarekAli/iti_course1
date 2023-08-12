package com.a7med.iti_course1.ui

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.a7med.iti_course1.R
import com.a7med.iti_course1.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var  sharRefrens:SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharRefrens=applicationContext.getSharedPreferences("USERPROF", MODE_PRIVATE)
        var dialoginterface = DialogInterface.OnClickListener { dialog, which ->
            if (which == -1) {
                Toast.makeText(this, "ok click ", Toast.LENGTH_SHORT).show()
            } else if (which == -2) {
                Toast.makeText(this, "No Click ", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "natural click ", Toast.LENGTH_SHORT).show()
            }


        }

        //dialog
        binding.login2.setOnClickListener {
            var bulder = AlertDialog.Builder(this)

            bulder.setTitle("Welcome")
            bulder.setMessage("Dialog Message")
            bulder.setCancelable(false)
            bulder.setPositiveButton("Okay", dialoginterface)
            bulder.setNegativeButton("No", dialoginterface)
            bulder.create().show()
        }



        binding.login.setOnClickListener {
          var editor=sharRefrens.edit()
            editor.putString("USERNAME",binding.editTtext.text.toString())
            editor.putString("PASSWORD",binding.passwrdEd.text.toString())
            editor.putBoolean("ISLOGIN",true)
            editor.commit()
            finish()

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
            startActivity(intent)
            finish()

        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activty, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println(item.itemId)

        return when (item.itemId) {

            R.id.go -> {
                startActivity(Intent(this, ThirdActivity::class.java))
                return true
            }

            R.id.exit -> {
                var bulder2 = AlertDialog.Builder(this)

                bulder2.setTitle("Welcome")
                bulder2.setMessage("Dialog Message")
                bulder2.setCancelable(false)
                var dialoginterface2 = null
                bulder2.setPositiveButton("Okay", dialoginterface2)
                bulder2.setNegativeButton("No", dialoginterface2)
                bulder2.create().show()

                return true


            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }


    }
}




