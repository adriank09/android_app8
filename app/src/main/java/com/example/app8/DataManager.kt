package com.example.app8

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataManager(context: Context) {
    // tag
    private val TAG = "DataManager"
    // the actual database
    private val db: SQLiteDatabase
    init {
        // create an instance of our internal CustomSQLiteOpenHelper class
        val helper = CustomSQLiteOpenHelper(context)
        db = helper.writableDatabase
    }
    companion object {
        const val TABLE_ROW_ID = "id"
        const val TABLE_ROW_NAME = "name"
        const val TABLE_ROW_AGE = "age"

        private const val DB_NAME = "address_book_db"
        private const val DB_VERSION = 1
        private const val TABLE_N_AND_A = "names_and_addresses"
    }

    // Insert a record
    fun insert(name: String, age: Int) {
        val query =
            "INSERT INTO $TABLE_N_AND_A ($TABLE_ROW_NAME, $TABLE_ROW_AGE) VALUES ('$name', '$age');"
        Log.i(TAG, "insert() = $query")
        db.execSQL(query)
    }

    // Delete a record
    fun delete(name: String) {
        val query = "DELETE FROM $TABLE_N_AND_A WHERE $TABLE_ROW_NAME = '$name';"
        Log.i(TAG, "delete() = $query")
        db.execSQL(query)
    }

    // Get all records
    fun selectAll() : Cursor {
        return db.rawQuery("SELECT * FROM $TABLE_N_AND_A;", null)
    }

    // Find a specific record
    fun searchName(name: String) : Cursor {
        val query = "SELECT $TABLE_ROW_ID, $TABLE_ROW_NAME, $TABLE_ROW_AGE FROM $TABLE_N_AND_A WHERE $TABLE_ROW_NAME = '$name';"
        Log.i(TAG, "searchName() = $query")
        return db.rawQuery(query, null)
    }

    private inner class CustomSQLiteOpenHelper(context: Context) :
        SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
        // Functions run only once the first time when DB is created
        override fun onCreate(p0: SQLiteDatabase?) {
            // Create a table for photos and all their details
            val newTableQueryString = "CREATE TABLE $TABLE_N_AND_A (" +
                    "$TABLE_ROW_ID integer primary key autoincrement not null," +
                    "$TABLE_ROW_NAME text not null," +
                    "$TABLE_ROW_AGE text not null" +
                    ");"
            p0!!.execSQL(newTableQueryString)
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            TODO("Not yet implemented")
        }
    }
}

