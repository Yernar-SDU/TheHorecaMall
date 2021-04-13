package com.example.thehorecamall.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.thehorecamall.R


class SendCodeActivity : AppCompatActivity(), TextWatcher {
    lateinit var editText : EditText
    lateinit var hint_text: TextView
    lateinit var button_send_code : Button
    var editTextString : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_code_layout)
        var index = 0
        editText = findViewById<EditText>(R.id.phone_number)
        hint_text = findViewById<TextView>(R.id.hint_text)
        button_send_code = findViewById<Button>(R.id.sendCode)
        editText.addTextChangedListener(this)


    }

    fun openPasteCodeActivity(view : View){
        if(editTextString.length == 10){
            intent = Intent(this@SendCodeActivity, PasteCodeActivity::class.java).apply {  }
            startActivity(intent)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val length = s.toString().replace(" ","").length
        editTextString = s.toString().replace(" ","")
        val  f1 = "X"
        val  f2 = "XX"
        val  f3 = "XXX"
        val  f4 = "XXXX"
        val  f5 = "X XXXX"
        val  f6 = "XX XXXX"
        val  f7 = "XXX XXXX"
        val  f8 = "X XXX XXXX"
        val  f9 = "XX XXX XXXX"
        val  f10 = "XXX XXX XXXX"
        if(length == 0){hint_text.setText(f10)}
        else if(length == 1){hint_text.setText(f9)}
        else if(length == 2){hint_text.setText(f8)}
        else if(length == 3){hint_text.setText(f7)}
        else if(length == 4){hint_text.setText(f6)}
        else if(length == 5){hint_text.setText(f5)}
        else if(length == 6){hint_text.setText(f4)}
        else if(length == 7){hint_text.setText(f3)}
        else if(length == 8){hint_text.setText(f2)}
        else if(length == 9){hint_text.setText(f1)}
        else if(length == 10){ hint_text.setText("")}

        if(length == 10){
            button_send_code.setBackgroundResource(R.drawable.button_background_orange)
        }else{
            button_send_code.setBackgroundResource(R.drawable.grey_button_background)
        }

    }

    override fun afterTextChanged(s: Editable?) {
    }
}
