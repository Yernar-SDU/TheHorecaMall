package com.example.thehorecamall.ui.detegrents

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.thehorecamall.MainActivity
import com.example.thehorecamall.R

class DetergentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detergents_layout)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DetergentsFragment())
                .commit()

    }

    fun openMainActivityPage(view: View) {
        val intent = Intent(this@DetergentsActivity, MainActivity::class.java).apply {  }
        startActivity(intent)
    }


}