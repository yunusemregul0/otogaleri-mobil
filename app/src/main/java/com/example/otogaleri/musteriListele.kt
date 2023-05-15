package com.example.otogaleri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.otogaleri.databinding.ActivityMusteriListeleBinding
import com.google.firebase.database.*
import com.google.firebase.firestore.auth.User

class musteriListele : AppCompatActivity() {
    lateinit var binding: ActivityMusteriListeleBinding
    private lateinit var dbref:DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<Musteri>
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMusteriListeleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        userRecyclerView=binding.userlist
        userRecyclerView.layoutManager=LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)
        userArrayList= arrayListOf<Musteri>()
        getUserData()

        binding.adduser.setOnClickListener {
            intent = Intent(applicationContext, musteriKayit::class.java)
            startActivity(intent)
        }


    }

    private fun getUserData() {
        dbref=FirebaseDatabase.getInstance().getReference("Musteri")
        dbref.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val user =userSnapshot.getValue(Musteri::class.java)
                        userArrayList.add(user!!)
                    }
                    userRecyclerView.adapter=CustomAdapter(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }



}