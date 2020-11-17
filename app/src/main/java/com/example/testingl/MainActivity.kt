package com.example.testingl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.go_to_products_page ->{
              startActivity(Intent(this, ProductsActivity::class.java))
                    true
            }
            R.id.go_to_cart ->{
                    true
            }
            R.id.settings ->{
                    true
            }
            R.id.change_password ->{
                    true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}