package com.example.tarea9_practica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_siguiente)
        button.setOnClickListener {
            val intent = Intent(this, map::class.java)
            intent.putExtra("NOMBRE", findViewById<EditText>(R.id.nombre_id).text.toString())
            intent.putExtra("APELLIDO", findViewById<EditText>(R.id.apellido_id).text.toString())
            intent.putExtra("LATITUD", findViewById<EditText>(R.id.latitud_id).text.toString())
            intent.putExtra("LONGITUD", findViewById<EditText>(R.id.longitud_id).text.toString())
            startActivity(intent)
        }

    }
}