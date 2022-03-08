package com.pourkazemi.mahdi.maktab_hw8

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pourkazemi.mahdi.maktab_hw8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val shared=getSharedPreferences("myShared", Context.MODE_PRIVATE)
        val eShared=shared.edit()
        bind.checkbox2.isChecked = !bind.checkbox.isChecked
        bind.checkbox.setOnCheckedChangeListener { compoundButton, b ->
            bind.checkbox2.isChecked=!b
        }
        bind.checkbox2.setOnCheckedChangeListener { compoundButton, b ->
            bind.checkbox.isChecked=!b
        }
        bind.register.setOnClickListener {
            eShared.apply{
                putString("fullName", bind.fullNameEdit.text.toString())
                putString("userName", bind.userNameEdit.text.toString())
                putString("email", bind.emailEdit.text.toString())
                putString("password", bind.passwordEdit.text.toString())
               if(bind.checkbox.isChecked){
                   putString("gender","female")
               }else{
                   putString("gender","male")
               }
                apply()
            }
        }
        bind.showInfo.setOnClickListener {
            bind.showFullName.text=shared.getString("fullName",null)
            bind.showUserName.text=shared.getString("userName",null)
            bind.showEmail.text=shared.getString("email",null)
            bind.showPassword.text=shared.getString("password",null)
            bind.showGender.text=shared.getString("gender",null)

            bind.hideLayout.visibility = View.VISIBLE
        }
        bind.hideButton.setOnClickListener {
            bind.hideLayout.visibility = View.GONE
        }
    }
}