package com.duyguorhan.yemeksiparisi

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.duyguorhan.yemeksiparisi.databinding.ActivityCustomerRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.view.View
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_customer_register.*
import java.lang.Exception

class CustomerRegister : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustomerRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.SignUpBtn.setOnClickListener {
            val customerName= binding.CustomerNameTxt.text.toString().trim()
            val customerSurname= binding.CustomSurnameTxt.text.toString().trim()
            val email = binding.CustomerMail.text.toString().trim()
            val pass = binding.CustomerPassword.text.toString().trim()
            val customerPhone= binding.CustomerPhoneNumber.text.toString().trim()
            val customerCity= binding.CustomerCity.text.toString().trim()
            val customerDistrict= binding.CustomerDistrict.text.toString().trim()
            val customerAddress= binding.CustomerAddress.text.toString().trim()

            var database = FirebaseDatabase.getInstance()
            var databaseReference = database.reference.child("Users")
            var id =databaseReference.push()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    id.child("id").setValue(id.key.toString())
                    id.child("adi").setValue(customerName)
                    id.child("soyadi").setValue(customerSurname)

                    id.child("phone").setValue(customerPhone)
                    id.child("city").setValue(customerCity)
                    id.child("district").setValue(customerDistrict)
                    id.child("address").setValue(customerAddress)

                    if (it.isSuccessful) {
                        id.child("email").setValue(email)
                        id.child("password").setValue(pass)
                        val intent = Intent(this,
                            RestaurantMainActivity::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }



                }

            } else
             {
                Toast.makeText(this, "Sign up failed", Toast.LENGTH_SHORT).show()
            }

        }
    }
}




