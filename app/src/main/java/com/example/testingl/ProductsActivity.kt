package com.example.testingl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val productsArray = arrayOf("Item 1", "Item 2","Item 3", "Item 4", "Item 5")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productsArray)
        val productsListView = findViewById<ListView>(R.id.productsListView)
        productsListView.adapter = adapter

        productsListView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id  ->
            Log.i("Position", "Position $position")
            val intent = Intent(this, ProductDetailsActivity::class.java)
            intent.putExtra("product", productsArray[position])
            startActivity(intent)
        }
    }
}