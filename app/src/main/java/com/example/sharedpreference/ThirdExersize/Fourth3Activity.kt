package com.example.sharedpreference.ThirdExersize

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.ActivityFourth2Binding
import com.example.sharedpreference.databinding.ActivityFourth3Binding
import com.example.sharedpreference.mySharedPreferences.MySharedPreferences

class Fourth3Activity : AppCompatActivity() {
    lateinit var binding: ActivityFourth3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourth3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreferences.init(this)
        var contactList = MySharedPreferences.contactList
        val adapter = ContactAdapter(this,contactList)
        binding.contactListView.adapter = adapter
    }


}
class ContactAdapter(context: Context, contacts: List<Contacts>) :
    ArrayAdapter<Contacts>(context, 0, contacts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false)
        }

        val currentContact = getItem(position)

        val nameTextView = itemView?.findViewById<TextView>(R.id.nameTextView)
        val phoneTextView = itemView?.findViewById<TextView>(R.id.phoneTextView)

        nameTextView?.text = currentContact?.username
        phoneTextView?.text = currentContact?.number

        return itemView!!
    }
}

