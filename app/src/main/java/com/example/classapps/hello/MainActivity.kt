package com.example.classapps.hello

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.classapps.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSend = findViewById<Button>(R.id.buttonSend)
        val userText = findViewById<EditText>(R.id.etName)

        buttonSend.setOnClickListener {
            Log.i("buttonSend", "Sending")
            val name = userText.text.toString()
            if (name.isNotEmpty()) {
                val textIntent = Intent(this, HelloActivity::class.java)
                textIntent.putExtra("extra_name", name)
                startActivity(textIntent)
            }
        }
    }
}