package com.example.otogaleri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.otogaleri.databinding.ActivityMainBinding
import com.example.otogaleri.databinding.ActivityMusteriKayitBinding
import com.google.firebase.database.FirebaseDatabase

class musteriKayit : AppCompatActivity() {
    lateinit var binding: ActivityMusteriKayitBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMusteriKayitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var database2 = FirebaseDatabase.getInstance().reference
        binding.mkayit.setOnClickListener {

            var etadres = binding.adres.text.toString()
            var etadsoyad = binding.adsoyad.text.toString()
            var etemail = binding.email.text.toString()
            var etTC = binding.TC.text.toString().toInt()
            var ettelefon = binding.telefon.text.toString().toInt()



            val musteriId = database2.push().key
            val musteri = Musteri(etadres,etadsoyad,etemail,etTC,ettelefon)

            if (musteriId != null) {
                database2.child("Musteri").child(musteriId).setValue(musteri)
            }
            Toast.makeText(this, "Veriler başarıyla kaydedildi.", Toast.LENGTH_SHORT).show()
        }
        binding.miptal.setOnClickListener {
            Toast.makeText(this, "Veri kayıtı iptal edildi", Toast.LENGTH_SHORT).show()
            finish()
        }


        }
    }
