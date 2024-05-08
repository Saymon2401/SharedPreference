package com.example.sharedpreference.ThirdExersize

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.ActivityFourth2Binding
import com.example.sharedpreference.databinding.ActivityFourthBinding
import com.example.sharedpreference.mySharedPreferences.MySharedPreferences
import com.google.gson.Gson

class Fourth2Activity : AppCompatActivity() {
    lateinit var binding: ActivityFourth2Binding
    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourth2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreferences.init(this)
        var contactList = mutableListOf<Contacts>()
        gson = Gson()

        binding.addBtn.setOnClickListener {
            var user = binding.userName.text.toString()
            var number = binding.userNumber.text.toString()
            var contact = Contacts(user,number)
            contactList.add(contact)
            MySharedPreferences.addContact(contact)
            val intent = Intent(this,FourthActivity::class.java)
            startActivity(intent)
        }
    }
}