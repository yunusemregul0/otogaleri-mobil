package com.example.otogaleri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.otogaleri.databinding.ActivityAracresimleriBinding
import com.example.otogaleri.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

class aracresimleri : AppCompatActivity() {
    lateinit var binding: ActivityAracresimleriBinding
    private lateinit var firestore:FirebaseFirestore
    private lateinit var storage:FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityAracresimleriBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firestore= Firebase.firestore
        storage=Firebase.storage



    }
}