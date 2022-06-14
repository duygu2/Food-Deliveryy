package com.duyguorhan.yemeksiparisi

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.duyguorhan.yemeksiparisi.databinding.ActivityRestaurantFoodAddBinding
import com.duyguorhan.yemeksiparisi.databinding.ActivityRestaurantRegisterBinding
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.view.View
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_restaurant_food_add.*
import java.util.*
import java.util.jar.Manifest

class RestaurantFoodAddActivity : AppCompatActivity() {
    var imageView: ImageView?=null
    var secilenGorsel: Uri?=null
    var secilenBitmap: Bitmap?=null

    lateinit var binding:ActivityRestaurantFoodAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         

    }




}