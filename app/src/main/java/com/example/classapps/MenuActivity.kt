package com.example.classapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.classapps.IMCapp.IMCActivity
import com.example.classapps.hello.MainActivity
import com.example.classapps.message.MessageActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        var btnIMCApp = findViewById<Button>(R.id.btnIMCApp)

        btnHelloApp.setOnClickListener { navigateToHelloApp() }
        btnMessageApp.setOnClickListener { navigateToMessageApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }

    }

    private fun navigateToIMCApp() {
        var intent = Intent(this,IMCActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMessageApp() {
        var intent = Intent(this, MessageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHelloApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}