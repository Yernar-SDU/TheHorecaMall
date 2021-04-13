package com.example.thehorecamall.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thehorecamall.R
import com.example.thehorecamall.model.Address

class AddressAdapter(list: List<Address>) : RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {
    private var list : List<Address> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        var root : View
        root = LayoutInflater.from(parent.context).inflate(R.layout.address_place_layout,parent,false)


        return AddressViewHolder(root)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        holder.street.setText(list[position].street)
        holder.address_name.setText(list[position].nameOfTheAddress)
        holder.podezd.setText(list[position].podezd)
        holder.position.setText(position.toString())
        if(position == 0){
            holder.image.setImageResource(R.drawable.home_address)
        }
        if(position == 1){
            holder.image.setImageResource(R.drawable.work_address)

        }
    }


    class AddressViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var position : TextView = itemView.findViewById(R.id.position)
        var street : TextView = itemView.findViewById(R.id.street)
        var podezd : TextView = itemView.findViewById(R.id.podezd)
        var address_name : TextView = itemView.findViewById(R.id.address_name)
        var image : ImageView = itemView.findViewById(R.id.image_geo)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}