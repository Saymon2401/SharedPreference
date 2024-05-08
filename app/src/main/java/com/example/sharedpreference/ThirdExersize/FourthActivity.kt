package com.example.sharedpreference.ThirdExersize

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.ActivityFourthBinding
import com.example.sharedpreference.mySharedPreferences.MySharedPreferences

class FourthActivity : AppCompatActivity() {
    lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreferences.init(this)
        binding.listUserBtn.setOnClickListener {
            val intent = Intent(this,Fourth3Activity::class.java)
            startActivity(intent)
        }
        binding.addUserBtn.setOnClickListener {
            val intent = Intent(this,Fourth2Activity::class.java)
            startActivity(intent)
        }
    }
}