package com.example.otogaleri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.otogaleri.databinding.ActivityMainBinding
import com.example.otogaleri.databinding.ActivitySatislarBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

class satislar : AppCompatActivity() {
    lateinit var binding: ActivitySatislarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivitySatislarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var database3 = FirebaseDatabase.getInstance().reference
        var getdata4=object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb4= StringBuilder() //metin birlestirme
                for (i in snapshot.children){
                    var aracNo=i.child("aracNo").getValue()
                    var tcNo=i.child("tcNo").getValue()


                    sb4.append("${i.key} $aracNo $tcNo  \n")
                }
                binding.textView8.setText(sb4)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        database3.child("Satislar").addValueEventListener(getdata4)
        database3.child("Satislar").addListenerForSingleValueEvent(getdata4)


        binding.sozgeridon.setOnClickListener {
            intent = Intent(applicationContext, sozlesmeSayfasi::class.java)
            startActivity(intent)

        }
    }
}
