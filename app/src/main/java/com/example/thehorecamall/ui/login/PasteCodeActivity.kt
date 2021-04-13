package com.example.thehorecamall.ui.login

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.thehorecamall.R

class PasteCodeActivity : AppCompatActivity() , TextWatcher {
    lateinit var hint_text : TextView
    lateinit var button_send_code : Button
    lateinit var timer_text : TextView
    lateinit var wrongCode : TextView
    var editTextString : String = ""
    val handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paste_code_layout)
        val editText = findViewById<EditText>(R.id.get_code)
        editText.addTextChangedListener(this)
        hint_text = findViewById(R.id.hint_text)
        button_send_code = findViewById<Button>(R.id.sendCode)
        timer_text = findViewById(R.id.timer)
        wrongCode = findViewById(R.id.wrongCode)
        startHandler()
    }

    fun startHandler(){
        var seconds = 59
        var start = true
        lateinit var runnableCode : Runnable
        runnableCode = Runnable {
            timer_text.setText("Отправить повторно можно через 00:%02d".format(seconds))
            seconds--

            handler.postDelayed(runnableCode,1000)
            if (seconds == -1){
                start = false
                timer_text.setText("Отправить повторно")
                timer_text.isClickable = true
                timer_text.setTextColor(resources.getColor(R.color.orange))
                timer_text.setOnClickListener(View.OnClickListener {
                    sendAgainCode()
                })
                handler.removeCallbacks(runnableCode)

            }
        }
        if(start){
            handler.postDelayed(runnableCode,1000)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        editTextString = s.toString().replace(" ", "")
        val length = s.toString().replace(" ", "").length
        val  f1 = "*"
        val  f2 = "* *"
        val  f3 = "* * *"
        val  f4 = "* * * *"
        val  f5 = "* * * * *"
        val  f6 = "* * * * * *"
        if(length == 0){hint_text.setText(f6)}
        else if(length == 1){hint_text.setText(f5)}
        else if(length == 2){hint_text.setText(f4)}
        else if(length == 3){hint_text.setText(f3)}
        else if(length == 4){hint_text.setText(f2)}
        else if(length == 5){hint_text.setText(f1)}
        else if(length == 6){
            hint_text.setText("")
            button_send_code.setBackgroundResource(R.drawable.button_background_orange)
        }

        if(length != 6){
            button_send_code.setBackgroundResource(R.drawable.grey_button_background)
        }

    }

    override fun afterTextChanged(s: Editable?) {
    }


    fun sendCodeAndContinue(view: View){
        if(editTextString != "000000"){
            wrongCode.visibility = View.VISIBLE
            //Sends the code
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null);
    }

    fun sendAgainCode(){}
}