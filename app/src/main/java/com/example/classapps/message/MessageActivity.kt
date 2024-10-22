package com.example.classapps.message

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.classapps.R

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val buttonSend = findViewById<Button>(R.id.buttonSend)
        val userText = findViewById<EditText>(R.id.etName)

        val messageText = findViewById<TextView>(R.id.tvMessage)
        val receivedMessage: String = intent.extras?.getString("extra_message").orEmpty()
        messageText.text = "$receivedMessage"

        buttonSend.setOnClickListener {
            Log.i("buttonSend", "Sending")
            val sentMessage = userText.text.toString()
            if (sentMessage.isNotEmpty()) {
                val textIntent = Intent(this, ReceiveActivity::class.java)
                textIntent.putExtra("extra_message", sentMessage)
                startActivity(textIntent)
            }
        }
    }
}