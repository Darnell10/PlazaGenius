package com.example.plazagenius.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.plazagenius.MainActivity
import com.example.plazagenius.R

class GP_Splash : AppCompatActivity() {

    private val SPLASHTIME:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gp__splash)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))

            finish()
        }, SPLASHTIME)
    }
}
