package com.example.thehorecamall.adapter

import CityModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thehorecamall.R
import com.example.thehorecamall.model.Address

class AutoCompleteAddressAdapter(list: List<CityModel>) : RecyclerView.Adapter<AutoCompleteAddressAdapter.AutoCompleteAddressViewHolder>() {
    private var list : List<CityModel> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoCompleteAddressViewHolder {
        var root : View
        root = LayoutInflater.from(parent.context).inflate(R.layout.hint_address_place_layout,parent,false)


        return AutoCompleteAddressViewHolder(root)
    }

    override fun onBindViewHolder(holder: AutoCompleteAddressViewHolder, position: Int) {
        holder.street.setText(list[position].street)
        holder.city.setText(list[position].country)
        holder.country.setText(list[position].country)
    }



    class AutoCompleteAddressViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var street : TextView = itemView.findViewById(R.id.street)
        var city : TextView = itemView.findViewById(R.id.city)
        var country : TextView = itemView.findViewById(R.id.country)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}