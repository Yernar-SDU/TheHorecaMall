package com.example.thehorecamall.ui.address_choose

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thehorecamall.R
import com.example.thehorecamall.adapter.AddressAdapter
import com.example.thehorecamall.model.Address


class ChooseAddressActivity : AppCompatActivity() {
    lateinit var address_RecycleView : RecyclerView
    var addresses : MutableList<Address> = arrayListOf(Address("Добавить офис","","")
            ,Address("Добавить склад","",""))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_address_layout)


        address_RecycleView = findViewById(R.id.choose_address_recycleView)
        val address_adapter : AddressAdapter = AddressAdapter(addresses)
        address_RecycleView.adapter = address_adapter
        address_RecycleView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val intent : Intent= getIntent()
        if(intent.extras != null){
            val justDelete : Boolean = intent.getBooleanExtra("justDelete",false)
            val position : String = intent.getStringExtra("position").toString()
            if(justDelete){
                addresses.removeAt(position.toInt())
                address_adapter.notifyDataSetChanged()
                return
            }
            val nameOfTheAddress : String = intent.getStringExtra("nameOfTheAddress").toString()
            val finalStreet : String = intent.getStringExtra("finalStreet").toString()
            val podezd : String = intent.getStringExtra("podezdEditText").toString()
            val address = Address(nameOfTheAddress,finalStreet,podezd)
            if(addresses.size > position.toInt()){
                addresses.removeAt(position.toInt())
            }
            addresses.add(position.toInt(),address)
            address_adapter.notifyDataSetChanged()
        }
    }

    fun addAddressToRecyclerView(view: View){
        val scrollView : ScrollView = findViewById(R.id.parent_layout)
        scrollView.setBackgroundResource(R.color.shadow);
        val positionTextView : TextView = view.findViewById(R.id.position)
        val args = Bundle()
        if(positionTextView.text.toString().toInt() == -1){
            args.putString("position",addresses.size.toString())
        }else{
            args.putString("position",positionTextView.text.toString())
        }
        val fragment = StreetTypingFragment()
        fragment.arguments = args
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentForAddingAddresses, fragment)
                .commit()

    }

}