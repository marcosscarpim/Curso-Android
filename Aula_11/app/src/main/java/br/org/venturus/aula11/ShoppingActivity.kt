package br.org.venturus.aula11

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ShoppingAdapter(ShoppingData().loadItems()) { product ->
            Toast.makeText(this, "'${product.name}' clicked", Toast.LENGTH_SHORT).show()
        }
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}