@file:Suppress("UNREACHABLE_CODE")

package com.example.class02.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
        db?.execSQL("create table productos(id_productos int primary key, nombre text, precio real)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
        if (oldVersion < 2) {
            db?.execSQL("ALTER TABLE productos ADD COLUMN descripcion TEXT")
        }
    }
}