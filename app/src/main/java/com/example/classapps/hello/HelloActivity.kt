package com.example.classapps.hello

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.classapps.R

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val textoHola = findViewById<TextView>(R.id.helloText)
        val nombre: String = intent.extras?.getString("extra_name").orEmpty()
        textoHola.text = "Hola $nombre"
    }
}