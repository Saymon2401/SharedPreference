package com.example.sharedpreference.secondExersize

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.ActivityThird2Binding
import com.example.sharedpreference.mySharedPreferences.MySharedPreferences

class Third2Activity : AppCompatActivity() {
    lateinit var binding: ActivityThird2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThird2Binding.inflate(layoutInflater)
        MySharedPreferences.init(this)
        setContentView(binding.root)
        var activated = false
        var backColor = MySharedPreferences.switchBool

        if (backColor == true){
            binding.switch1.isChecked = true
            activated = true
        } else{
            binding.switch1.isChecked = false
            activated = false
        }

        binding.switch1.setOnCheckedChangeListener{ button,isChaked ->
            activated = if (binding.switch1.isChecked) true else false
        }

        binding.close.setOnClickListener {
            MySharedPreferences.switchBool = activated
            val intent = Intent(this,ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}