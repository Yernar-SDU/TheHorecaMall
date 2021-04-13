package com.example.thehorecamall.ui.chat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thehorecamall.*
import com.example.thehorecamall.adapter.MessagesAdapter
import com.example.thehorecamall.model.ChatMessage
import com.example.thehorecamall.model.User
import java.util.*

class ChatActivity : AppCompatActivity(){
    lateinit var chat_messaages_recycleView : RecyclerView
    lateinit var no_messages_text : TextView
    lateinit var user_message_edit_text : EditText
    lateinit var list : MutableList<ChatMessage>
    lateinit var messagesAdapter : MessagesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_layout)
        val string_Date = "12:01"
        val chatMessage0 : ChatMessage = ChatMessage("Здравствуйте, Не получил.",true,string_Date, User("Yernar"))
        val chatMessage1 : ChatMessage = ChatMessage("Добрый день! Через полчаса будет.",false,string_Date, User("Rabotnik"))

        list =  arrayListOf<ChatMessage>(chatMessage0,chatMessage1)


        chat_messaages_recycleView = findViewById(R.id.recycleView)
        no_messages_text = findViewById(R.id.no_messages_text)
        user_message_edit_text = findViewById(R.id.edit_text_user_message)


        messagesAdapter = MessagesAdapter(list)

        chat_messaages_recycleView.adapter = messagesAdapter
        chat_messaages_recycleView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)



        if(list.isEmpty()){
            no_messages_text.visibility = View.VISIBLE
        }else{
            no_messages_text.visibility = View.INVISIBLE
        }

    }

    fun onSendButtonClick(view : View){
        if(user_message_edit_text.text == null){
            Toast.makeText(baseContext,"Please write something",Toast.LENGTH_SHORT).show()
        }else{
            val date : Date = Calendar.getInstance().time
            val date_string = "%02d:%02d".format(date.hours,date.minutes)
            val user : User = User("Yernar")
            val chatMessage0 : ChatMessage = ChatMessage(user_message_edit_text.text.toString(),true,date_string, user)
            list.add(chatMessage0)
            messagesAdapter.notifyDataSetChanged()
            user_message_edit_text.setText("")
        }
    }

    fun openMainActivityPage(view: View) {
        val intent = Intent(this@ChatActivity, MainActivity::class.java).apply {  }
        startActivity(intent)
    }




}