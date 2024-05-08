package com.example.sharedpreference

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("pdp_online", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        binding.saveBtn.setOnClickListener {
            var text = binding.edit.text.toString()
            editor.putString("key1",text)
            editor.commit()
        }
        binding.showBtn.setOnClickListener {
//            var str = sharedPreferences.getString("key1","")
//            binding.tv.text = str
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}