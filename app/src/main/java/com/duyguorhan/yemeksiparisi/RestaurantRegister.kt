package com.duyguorhan.yemeksiparisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.duyguorhan.yemeksiparisi.databinding.ActivityCustomerRegisterBinding
import com.duyguorhan.yemeksiparisi.databinding.ActivityRestaurantRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RestaurantRegister : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurantRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.RestaurantSignUpBtn.setOnClickListener {
            val restaurantName= binding.RestaurantNameTxt.text.toString().trim()
            val email = binding.RestaurantMail.text.toString().trim()
            val pass = binding.RestaurantPassword.text.toString().trim()
            val restaurantPhone= binding.RestaurantPhoneNumber.text.toString().trim()
            val restaurantCity= binding.RestaurantCity.text.toString().trim()
            val restaurantDistrict= binding.RestaurantDistrict.text.toString().trim()
            val restaurantAddress= binding.RestaurantAddress.text.toString().trim()

            var database = FirebaseDatabase.getInstance()
            var databaseReference = database.reference.child("Restaurants")
            var id =databaseReference.push()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {

                    id.child("id").setValue(id.key.toString())
                    id.child("adi").setValue(restaurantName)
                    id.child("phone").setValue(restaurantPhone)
                    id.child("city").setValue(restaurantCity)
                    id.child("district").setValue(restaurantDistrict)
                    id.child("address").setValue(restaurantAddress)

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
                Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
            }

        }
    }
}









