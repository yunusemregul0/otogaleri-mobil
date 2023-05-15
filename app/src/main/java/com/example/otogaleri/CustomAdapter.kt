package com.example.otogaleri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class CustomAdapter(private val userList: ArrayList<Musteri>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvadres:TextView=view.findViewById(R.id.tvadres)
        val tvadsoyad:TextView=view.findViewById(R.id.tvadsoyad)
        val tvemail:TextView=view.findViewById(R.id.tvemail)
        val tvtc:TextView=view.findViewById(R.id.tvtc)
        val tvtelefon:TextView=view.findViewById(R.id.tvtelefon)


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvadres.text=userList[position].adres
        viewHolder.tvadsoyad.text= userList[position].adsoyad
        viewHolder.tvemail.text=userList[position].email
        viewHolder.tvtc.text= userList[position].tc.toString()
        viewHolder.tvtelefon.text=userList[position].telefon.toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = userList.size

}
