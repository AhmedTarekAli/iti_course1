package com.a7med.iti_course1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a7med.iti_course1.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    lateinit var  binding:ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var username =intent.extras?.getString("UserName")?:"null"
        binding.userSec.text=username

        binding.buttonLog.setOnClickListener {
            val logwith = if (binding.googleBu.isChecked){" Login with Google"}

            else{"Login with FaceBook"}
            var intent = Intent()
            intent.putExtra("Loginwith",logwith)
            setResult(2,intent)
            finish()
        }



    }
}