package com.a7med.iti_course1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.a7med.iti_course1.R
import com.a7med.iti_course1.adapters.Adpter
import com.a7med.iti_course1.databinding.ActivityThirdBinding
import com.a7med.iti_course1.network.ApiInterface
import com.a7med.iti_course1.network.RetrofitClint
import com.a7med.iti_course1.network.RetrofitClint.getRetrofit

class ThirdActivity : AppCompatActivity(), MyClickItem {
    lateinit var  binding:ActivityThirdBinding
    lateinit var myAdpter: Adpter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var username =intent.extras?.getString("UserName")?:"null"



         lifecycleScope.launchWhenCreated {
             val respons = getRetrofit().getUsers()

             if (respons.isSuccessful){

                 myAdpter= Adpter(respons.body()?.data ?: listOf(),this@ThirdActivity)
                 binding.userRec.layoutManager=LinearLayoutManager(this@ThirdActivity)
                 binding.userRec.adapter=myAdpter


             }else {
                 Toast.makeText(this@ThirdActivity,"error",Toast.LENGTH_SHORT).show()
             }

         }

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_third_activty, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println(item.itemId)

        return when (item.itemId) {

            R.id.login -> {
                val sharrefrens = applicationContext.getSharedPreferences("USERPROF", MODE_PRIVATE)
                var editor = sharrefrens.edit()
                editor.remove("USERNAME")
                editor.remove("PASSWORD")
                editor.putBoolean("ISLOGIN", false)
                editor.commit()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                return true
            }


            else -> {
                super.onOptionsItemSelected(item)
            }

        }}


      /*  override fun clickItem(post: TimeLine, position: Int) {
   Toast.makeText(this,"UserName ${post.firstname}   item num $position ",Toast.LENGTH_LONG).show()
    }*/}
