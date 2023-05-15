package com.example.otogaleri

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.otogaleri.databinding.ActivityAracListele2Binding
import com.example.otogaleri.databinding.ActivityMainBinding
import com.example.otogaleri.databinding.ActivityMusteriListeleBinding
import com.google.firebase.database.*

class aracListele2 : AppCompatActivity() {
    lateinit var binding: ActivityAracListele2Binding
    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<arac>
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityAracListele2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        userRecyclerView=binding.carlist
        userRecyclerView.layoutManager= LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)
        userArrayList= arrayListOf<arac>()
        getUserData()

        binding.addcar.setOnClickListener {
            intent = Intent(applicationContext, aracListele::class.java)
            startActivity(intent)
        }


    }

    private fun getUserData() {
        dbref=FirebaseDatabase.getInstance().getReference("Arac")
        dbref.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val car =userSnapshot.getValue(arac::class.java)
                        userArrayList.add(car!!)
                    }
                    userRecyclerView.adapter=CarAdapter(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }



}