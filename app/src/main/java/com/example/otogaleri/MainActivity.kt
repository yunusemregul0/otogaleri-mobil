package com.example.otogaleri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.otogaleri.databinding.ActivityMainBinding
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.arackayit.setOnClickListener {
            intent = Intent(applicationContext, aracListele::class.java)
            startActivity(intent)
        }
        binding.araclistele.setOnClickListener {
            intent = Intent(applicationContext, aracListele2::class.java)
            startActivity(intent)
        }
        binding.musterikayit.setOnClickListener {
            intent = Intent(applicationContext, musteriKayit::class.java)
            startActivity(intent)
        }
        binding.musterilistele.setOnClickListener {
            intent = Intent(applicationContext, musteriListele::class.java)
            startActivity(intent)


        }
        binding.sozlesme.setOnClickListener {
            intent = Intent(applicationContext, sozlesmeSayfasi::class.java)
            startActivity(intent)

        }
        binding.satislar.setOnClickListener {
            intent = Intent(applicationContext, satislar::class.java)
            startActivity(intent)

        }
    }
}