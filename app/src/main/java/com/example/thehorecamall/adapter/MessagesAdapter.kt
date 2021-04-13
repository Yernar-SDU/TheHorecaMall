package com.example.thehorecamall.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thehorecamall.R
import com.example.thehorecamall.model.ChatMessage

class MessagesAdapter(list: List<ChatMessage>) : RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>() {
    private var list : List<ChatMessage> = list
    private val MESSAGE_TYPE_SENDER = 1
    private val MESSAGE_TYPE_GETTER = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        var root : View
        if(viewType == MESSAGE_TYPE_SENDER)
             root = LayoutInflater.from(parent.context).inflate(R.layout.message_card_sender,parent,false)
        else{
            root = LayoutInflater.from(parent.context).inflate(R.layout.message_card_getter,parent,false)

        }

        return MessagesViewHolder(root)
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.context.setText(list[position].text)
        holder.wrote_date.setText(list[position].date)
    }



    override fun getItemViewType(position: Int): Int {
        if(list[position].user_Message){
            return MESSAGE_TYPE_SENDER
        }else{
            return MESSAGE_TYPE_GETTER
        }
    }




    class MessagesViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var context : TextView = itemView.findViewById(R.id.context)
        var wrote_date : TextView = itemView.findViewById(R.id.wrote_date)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}