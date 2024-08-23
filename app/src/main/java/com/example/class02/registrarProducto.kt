package com.example.class02

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.class02.db.AdminSQLiteOpenHelper

class registrarProducto : AppCompatActivity() {
    lateinit var  txtNomOro: EditText;
    lateinit var txtPrePro: EditText;
    lateinit var  btnRegis: Button;
    lateinit var txtCodigoPro: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrar_producto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        estadoBopton()
    }
    fun cargarR(){
        txtNomOro=findViewById(R.id.txtCodigoProducto)
        txtPrePro=findViewById(R.id.txtPrecioPro)
        txtCodigoPro=findViewById(R.id.txtCodigoProducto)
        btnRegis=findViewById(R.id.btnRegistrarProducto)

    }
    fun estadoBopton(){
        btnRegis.setOnClickListener{
            val adminSQL= AdminSQLiteOpenHelper(this,"administracion",null,1)
            val db=adminSQL.writableDatabase
            val registro= ContentValues()
            registro.put("id_productos",txtNomOro.text.toString())
            registro.put("nombre",txtNomOro.text.toString())
            registro.put("precio",txtPrePro.text.toString())
            db.insert("productos",null,registro)
            txtCodigoPro.setText("")
            txtNomOro.setText("")
            txtPrePro.setText("")
            Toast.makeText(this, "Se cargaron los datos del artículo", Toast.LENGTH_SHORT).show()

        }


    }
}