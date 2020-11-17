package com.example.testingl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.View
import android.widget.*

class ProductDetailsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val bookName= intent.getStringExtra("product")
        findViewById<TextView>(R.id.bookTitleTextView).text = bookName

        //spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        ArrayAdapter.createFromResource(this,R.array.book_options, android.R.layout.simple_spinner_item)
            .also { adapter -> adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            }
        spinner.onItemSelectedListener = this
        findViewById<Button>(R.id.ignoreButton).setOnClickListener{displayDialog()}
        val ImageView = findViewById<ImageView>(R.id.productImageView)
        registerForContextMenu(ImageView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.book_details_menu, menu)
    }
    fun displayDialog(){
        val ignoreFragmentDialog = IgnoreFragmentDialog()
        val fm = supportFragmentManager
        ignoreFragmentDialog.show(fm,"ignore_dialog")
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}