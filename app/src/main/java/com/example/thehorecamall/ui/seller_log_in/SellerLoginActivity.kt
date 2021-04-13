package com.example.thehorecamall.ui.seller_log_in

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.thehorecamall.R

class SellerLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
    }

    fun openRegisterActivity(view : View){
        intent = Intent(this@SellerLoginActivity,SellerRegisterActivity::class.java).apply {  }
        startActivity(intent)
    }
}