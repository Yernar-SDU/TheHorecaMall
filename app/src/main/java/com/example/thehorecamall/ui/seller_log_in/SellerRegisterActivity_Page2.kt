package com.example.thehorecamall.ui.seller_log_in

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.thehorecamall.R

class SellerRegisterActivity_Page2 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page_2)

        //Make keyboard hidden onCreate
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
    }


    fun openCompletePageActivity_Page2(view : View){
        intent = Intent(this@SellerRegisterActivity_Page2, SellerCompletePageActivity::class.java).apply {  }
        startActivity(intent)
    }
}