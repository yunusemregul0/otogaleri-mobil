package com.example.otogaleri

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.otogaleri.databinding.ActivityAracListele2Binding
import com.example.otogaleri.databinding.ActivitySozlesmeSayfasiBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class sozlesmeSayfasi : AppCompatActivity() {
    lateinit var binding: ActivitySozlesmeSayfasiBinding
    lateinit var tcNo: EditText
    lateinit var  aracNo:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        var database = FirebaseDatabase.getInstance().reference
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivitySozlesmeSayfasiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        tcNo=binding.soztcara
        aracNo=binding.sozaracno



        binding.sozara.setOnClickListener {
            var getdata2=object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    var sb2= StringBuilder() //metin birlestirme
                    for (i in snapshot.children){
                        var adres=i.child("adres").getValue()
                        var adsoyad=i.child("adsoyad").getValue()
                        var email=i.child("email").getValue()
                        var tc=i.child("tc").getValue()
                        var telefon=i.child("telefon").getValue()

                        if (tc != null && tc.toString() == tcNo.text.toString()) {
                            sb2.append("${i.key} $adres $adsoyad $email $tc $telefon \n")
                        }

                    }
                    binding.tvm.setText(sb2)

                }

                override fun onCancelled(error: DatabaseError) {

                }
            }
            database.child("Musteri").addValueEventListener(getdata2)
            database.child("Musteri").addListenerForSingleValueEvent(getdata2)

        }
        binding.sozaracara.setOnClickListener {
            var getdata3=object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    var sb3= StringBuilder() //metin birlestirme
                    for (i in snapshot.children){
                        var aracno=i.child("aracno").getValue()
                        var fiyat=i.child("fiyat").getValue()
                        var hasar=i.child("hasar").getValue()
                        var marka=i.child("marka").getValue()
                        var renk=i.child("renk").getValue()
                        var vites=i.child("vites").getValue()
                        var yakit=i.child("yakit").getValue()
                        var yil=i.child("yil").getValue()

                        if (aracno != null && aracno.toString() == aracNo.text.toString()) {
                            sb3.append("${i.key} $aracno $fiyat $hasar $marka $renk $vites $yakit $yil \n")
                        }

                    }
                    binding.tva.setText(sb3)

                }

                override fun onCancelled(error: DatabaseError) {

                }
            }
            database.child("Arac").addValueEventListener(getdata3)
            database.child("Arac").addListenerForSingleValueEvent(getdata3)

        }
        binding.satisekle.setOnClickListener {
            val tcNoText = tcNo.text.toString()
            val aracNoText = aracNo.text.toString()




            // Satışı Firebase veritabanına kaydet
            database.child("Satislar").push().setValue(mapOf(
                "tcNo" to tcNoText,
                "aracNo" to aracNoText,



            ))
            Toast.makeText(this, "Satış başarıyla kaydedildi.", Toast.LENGTH_SHORT).show()

        }


    }



}
