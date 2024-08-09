package com.example.class02.model

class Productos  constructor(nombre:String, precio:Double) {

    var nombre: String = nombre
        get() = field
        set(value) {
            field = value

        }

    var precio: Double = precio
        get() = field
        set(value) {
            field = value
        }

    fun calIVA(iva: Double): Double {
        return precio * iva
    }
}