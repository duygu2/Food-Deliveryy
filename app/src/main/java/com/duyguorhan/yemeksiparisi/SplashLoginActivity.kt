package com.duyguorhan.yemeksiparisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashLoginActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_login)

        val ButtonCustomer=findViewById<Button>(R.id.btn_customer);
        ButtonCustomer.setOnClickListener {
            val intent= Intent(this,CustomerLogin::class.java)
            startActivity(intent)
        }

        val ButtonRestaurant=findViewById<Button>(R.id.btn_rest_login);
        ButtonRestaurant.setOnClickListener {
            val intent= Intent(this,RestaurantLogin::class.java)
            startActivity(intent)
        }

        val ButtonAdmin=findViewById<Button>(R.id.btn_admin);
        ButtonAdmin.setOnClickListener {
            val intent= Intent(this,AdminLogin::class.java)
            startActivity(intent)
        }
    }




}