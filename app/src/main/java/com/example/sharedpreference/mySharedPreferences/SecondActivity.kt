package com.example.sharedpreference.mySharedPreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.ActivityMain2Binding
import com.example.sharedpreference.databinding.ActivitySecondBinding
import com.google.gson.Gson

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        MySharedPreferences.init(this)
        gson = Gson()
        setContentView(binding.root)

        binding.registr.setOnClickListener {
            val intent = Intent(this,SecondActivity2::class.java)
            startActivity(intent)
        }
        binding.signBtn.setOnClickListener {
            var username = binding.userName.text.toString()
            var password = binding.password.text.toString()
            
            var userStr = MySharedPreferences.user
            if (userStr!="") {
                var user = gson.fromJson(userStr, User::class.java)
                if (user.username == username && user.password == password) {
                    val intent = Intent(this, SecondActivityWelcome::class.java)
                    startActivity(intent)
                } else Toast.makeText(this, "Username or Password is wrong", Toast.LENGTH_SHORT)
                    .show()
            }else Toast.makeText(this, "Username or Password is wrong", Toast.LENGTH_SHORT).show()
        }
    }
}