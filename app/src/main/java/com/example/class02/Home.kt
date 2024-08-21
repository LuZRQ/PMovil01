package com.example.class02

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import androidx.cardview.widget.CardView

class Home : AppCompatActivity() {
    lateinit var btnIvaPro: CardView
    lateinit var btnProduct: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()

        estadoBoton()
    }

    fun cargarR(){
        btnIvaPro = findViewById(R.id.btnCalcularIvaProduct)
        btnProduct = findViewById(R.id.btnProductos)
    }

    fun estadoBoton(){
        btnIvaPro.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        btnProduct.setOnClickListener{
            val i = Intent(this, registrarProducto::class.java)
            startActivity(i)
        }
    }

}