package com.example.otogaleri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class CarAdapter(private val userList: ArrayList<arac>) :
    RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvaracno:TextView=view.findViewById(R.id.tvm)
        val tvfiyat:TextView=view.findViewById(R.id.tva)
        val tvhasar:TextView=view.findViewById(R.id.tvhasar)
        val tvmarka:TextView=view.findViewById(R.id.tvmarka)
        val tvrenk:TextView=view.findViewById(R.id.tvrenk)
        val tvvites:TextView=view.findViewById(R.id.tvvites)
        val tvyakit:TextView=view.findViewById(R.id.tvyakit)
        val tvyil:TextView=view.findViewById(R.id.tvyil)


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.car_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvaracno.text= userList[position].aracno.toString()
        viewHolder.tvfiyat.text= userList[position].fiyat.toString()
        viewHolder.tvhasar.text=userList[position].hasar
        viewHolder.tvmarka.text= userList[position].marka
        viewHolder.tvrenk.text=userList[position].renk
        viewHolder.tvvites.text=userList[position].vites
        viewHolder.tvyakit.text=userList[position].yakit
        viewHolder.tvyil.text= userList[position].yil.toString().toInt().toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = userList.size

}
