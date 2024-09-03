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
import com.example.class02.model.Productos

class registrarProducto : AppCompatActivity() {
    lateinit var btnRegistroPro:Button
    lateinit var txtNom:EditText
    lateinit var txtPrecio:EditText
    lateinit var txtCodigo:EditText

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
        estadoBoton()
    }

    fun cargarR(){
        btnRegistroPro=findViewById(R.id.btnRegistroProducto)
        txtNom = findViewById(R.id.txtNombre)
        txtPrecio = findViewById(R.id.txtPrecio)
        txtCodigo = findViewById(R.id.txtCodigoProducto)
    }

    fun estadoBoton(){
        btnRegistroPro.setOnClickListener{
/*
            val adminsql = AdminSQLiteOpenHelper(this,"administracion",null,1)
            val db = adminsql.writableDatabase
            val registro = ContentValues()
//realizamos la instancia del objeto
            //el objeto crasea a que solo entre numeros y no  string, arreglar
            val objeto= Productos(txtNom.text.toString(),txtPrecio.text.toString().toDouble(), txtCodigo.text.toString().toInt())
            registro.put("id_productos", objeto.getProductos())
            registro.put("nombre", objeto.getNombre())
            registro.put("precio", objeto.getPrecio())
            db.insert("productos", null, registro)

            db.close()
            txtCodigo.setText("")
            txtNom.setText("")
            txtPrecio.setText("")
            Toast.makeText(this, "Se cargaron los datos del producto", Toast.LENGTH_SHORT).show()
            */
            try {


                val adminsql = AdminSQLiteOpenHelper(this, "administracion", null, 1)
                val db = adminsql.writableDatabase
                val registro = ContentValues()

                // Realizamos la instancia del objeto
                val objeto= Productos(txtNom.text.toString(),txtPrecio.text.toString().toDouble(), txtCodigo.text.toString().toInt())
                registro.put("id_productos", objeto.getProductos())
                registro.put("nombre", objeto.getNombre())
                registro.put("precio", objeto.getPrecio())

                db.insert("productos", null, registro)
                db.close()

                // Limpiamos los campos
                txtCodigo.setText("")
                txtNom.setText("")
                txtPrecio.setText("")

                Toast.makeText(this, "Se cargaron los datos del producto", Toast.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                // Mostramos un mensaje de error si se ingresan datos no válidos
                Toast.makeText(this, "Por favor, ingrese un código y precio válidos", Toast.LENGTH_SHORT).show()
            }
        }
    }

        }
