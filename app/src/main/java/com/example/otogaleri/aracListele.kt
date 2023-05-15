package com.example.otogaleri

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.otogaleri.databinding.ActivityAracListeleBinding
import com.google.firebase.database.FirebaseDatabase
import android.Manifest;
import android.app.Activity
import android.content.Intent
import android.content.pm.LauncherActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import java.net.URI


class aracListele : AppCompatActivity() {
    var pickedPhoto : Uri?=null
    var pickedBitmap : Bitmap?=null
    lateinit var binding: ActivityAracListeleBinding
    private lateinit var firestore:FirebaseFirestore
    private lateinit var storage:FirebaseStorage




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAracListeleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        firestore= Firebase.firestore
        storage= Firebase.storage

       // binding.imageView3.setOnClickListener { galeriyegit() }
       // binding.resimekle.setOnClickListener { upload(view) }


        var database = FirebaseDatabase.getInstance().reference

        binding.kayit.setOnClickListener {
            var etaracno = binding.aracno.text.toString().toInt()
            var etfiyat = binding.fiyat.text.toString().toInt()
            var ethasar = binding.spinnerhasar.selectedItem.toString()
            var etmarka = binding.spinnermarka.selectedItem.toString()
            var etrenk = binding.renk.text.toString()
            var etvites = binding.spinnervites.selectedItem.toString()
            var etyakit = binding.spinneryakit.selectedItem.toString()
            var etyil = binding.modelyili.text.toString().toInt()

            val aracId = database.push().key
            val arac = arac(etaracno,etfiyat, ethasar,  etmarka, etrenk, etvites, etyakit, etyil)

            if (aracId != null) {
                database.child("Arac").child(aracId).setValue(arac)
            }

            Toast.makeText(this, "Veriler başarıyla kaydedildi.", Toast.LENGTH_SHORT).show()
        }
        binding.iptal.setOnClickListener {
            Toast.makeText(this, "Veri kayıtı iptal edildi", Toast.LENGTH_SHORT).show()
            finish()
        }




        var markalar = resources.getStringArray(R.array.Markalar)
        val markaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, markalar)
        binding.spinnermarka.adapter = markaAdapter

        var yakit = resources.getStringArray(R.array.Yakit)
        val yakitAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, yakit)
        binding.spinneryakit.adapter = yakitAdapter

        var vites = resources.getStringArray(R.array.Vites)
        val vitesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, vites)
        binding.spinnervites.adapter = vitesAdapter

        var hasar = resources.getStringArray(R.array.Hasar)
        val hasarAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, hasar)
        binding.spinnerhasar.adapter = hasarAdapter
    }

    /*fun galeriyegit(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
        }
        else
        {

            val galleryIntext=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntext,2)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(grantResults.size>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            val galleryIntext=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntext,2)
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==2&&resultCode==Activity.RESULT_OK&&data!=null){
            pickedPhoto=data.data
            if(Build.VERSION.SDK_INT>=28){
                val source =ImageDecoder.createSource(this.contentResolver,pickedPhoto!!)
                pickedBitmap=ImageDecoder.decodeBitmap(source)
                binding.imageView3.setImageBitmap(pickedBitmap)

            }
            else{
                pickedBitmap=MediaStore.Images.Media.getBitmap(this.contentResolver,pickedPhoto)
                binding.imageView3.setImageBitmap(pickedBitmap)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    fun upload(view: View){
        val reference=storage.reference
        val imageReference=reference.child("images")
        if(pickedPhoto!=null){
            imageReference.putFile(pickedPhoto!!).addOnSuccessListener {

            }.addOnFailureListener{
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()

            }
        }
    }*/

}


