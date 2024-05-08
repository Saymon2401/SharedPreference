package com.example.sharedpreference.mySharedPreferences

import android.content.Context
import android.content.SharedPreferences
import com.example.sharedpreference.ThirdExersize.Contacts
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreferences {
    private const val NAME = "registration"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var text: String?
        get() = sharedPreferences.getString("key2", "")
        set(value) = MySharedPreferences.sharedPreferences.edit {
            if (value != null) {
                it.putString("key2", value)
            }
        }
    var user: String?
        get() = sharedPreferences.getString("key3", "")
        set(value) = MySharedPreferences.sharedPreferences.edit {
            if (value != null) {
                it.putString("key3", value)
            }
        }
    var switchBool: Boolean?
        get() = sharedPreferences.getBoolean("switch", false)
        set(value) = MySharedPreferences.sharedPreferences.edit {
            if (value != null) {
                it.putBoolean("switch", value)
            }
        }

    var contactList: List<Contacts>
        get() {
            val contactListString = sharedPreferences.getString("contact", null)
            return if (contactListString != null) {
                val type = object : TypeToken<List<Contacts>>() {}.type
                Gson().fromJson(contactListString, type)
            } else {
                listOf()
            }
        }
        set(value) {
            val contactListString = Gson().toJson(value)
            sharedPreferences.edit {
                it.putString("contact", contactListString)
            }
        }

    fun addContact(contact: Contacts) {
        val updatedList = contactList.toMutableList()
        updatedList.add(contact)
        contactList = updatedList
    }
}