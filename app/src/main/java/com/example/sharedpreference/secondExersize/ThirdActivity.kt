package com.example.sharedpreference.secondExersize

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.ActivitySecond2Binding
import com.example.sharedpreference.databinding.ActivityThirdBinding
import com.example.sharedpreference.mySharedPreferences.MySharedPreferences

class ThirdActivity : AppCompatActivity() {
    lateinit var binding: ActivityThirdBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        MySharedPreferences.init(this)
        setContentView(binding.root)
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this,Third2Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        var activ = MySharedPreferences.switchBool
        Log.d("main","Switch: $activ")
        if(activ==true){
            binding.main.setBackgroundColor(ContextCompat.getColor(this,R.color.black))
        }else binding.main.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
    }
}