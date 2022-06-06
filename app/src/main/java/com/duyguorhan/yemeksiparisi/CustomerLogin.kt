package com.duyguorhan.yemeksiparisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CustomerLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login)

        val ButtonCustomerLogin=findViewById<Button>(R.id.CustomerLoginBtn)
        ButtonCustomerLogin.setOnClickListener {
            val intent= Intent(this,CustomerRegister::class.java)
            startActivity(intent)
        }
    }
}