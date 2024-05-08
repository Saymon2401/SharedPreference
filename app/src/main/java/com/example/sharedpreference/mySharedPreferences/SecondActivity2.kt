package com.example.sharedpreference.mySharedPreferences

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.ActivitySecond2Binding
import com.example.sharedpreference.databinding.ActivitySecondBinding
import com.google.gson.Gson

class SecondActivity2 : AppCompatActivity() {
    lateinit var binding:ActivitySecond2Binding
    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecond2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreferences.init(this)
        gson = Gson()
        binding.signIn.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        binding.signUpBtn.setOnClickListener {
            val username = binding.userName.text.toString()
            val password = binding.password.text.toString()
            val user = User(username,password)
            val str = gson.toJson(user)
            MySharedPreferences.user = str
            finish()
        }
    }
}