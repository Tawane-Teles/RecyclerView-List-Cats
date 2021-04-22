package com.example.mylistcats

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylistcats.model.Cat

class MainActivity : AppCompatActivity() {

    private val adapterCats = CatsAdapter()
    var listCats: RecyclerView? = null
    var search: SearchView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Cat: List<Cat> =
            listOf(
                Cat("Emy Teles Rodrigues"),
                Cat("Cleido Teles Rodrigues"),
                Cat("Tiago Lima Rodrigues")
            )
        adapterCats.item = Cat
        adapterCats.catitem = Cat

        setupViews()
        setupRecyclerView()

        search?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapterCats.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapterCats.filter.filter(newText)
                return true
            }

        })
    }

    private fun setupViews() {
        listCats = findViewById(R.id.listCats)
        search = findViewById(R.id.searchView5)
    }

    private fun setupRecyclerView() {

        listCats?.layoutManager = LinearLayoutManager(this)
        listCats?.adapter = adapterCats


    }

}