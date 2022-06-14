package com.duyguorhan.yemeksiparisi

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.duyguorhan.yemeksiparisi.databinding.ActivityCustomerLoginBinding
import com.duyguorhan.yemeksiparisi.databinding.ActivityRestaurantLoginBinding
import com.google.firebase.auth.FirebaseAuth

class RestaurantLogin : AppCompatActivity() {
    //viewbinding
    private lateinit var binding: ActivityRestaurantLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()
        binding.RestaurantSignUp.setOnClickListener {
            val intent = Intent(this, RestaurantRegister::class.java)
            startActivity(intent)
        }

        binding.RestaurantLoginBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passwordEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, RestaurantFoodAddActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}
