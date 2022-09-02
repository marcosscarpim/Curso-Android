package br.org.venturus.aula11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingAdapter(
    private val list: List<Product>,
    private val onItemClicked: (Product) -> Unit
) : RecyclerView.Adapter<ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shopping, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val product = list[position]
        holder.bind(product)
        holder.itemView.setOnClickListener {
            onItemClicked(product)
        }
    }

    override fun getItemCount(): Int = list.size
}

class ShoppingViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(product: Product) {
        view.apply {
            findViewById<ImageView>(R.id.imageview_item_pic).setImageResource(product.image)
            findViewById<TextView>(R.id.textview_item_name).text = product.name
            findViewById<TextView>(R.id.textview_item_brand).text = product.brand
        }
    }
}

// interface funcional
//fun interface ItemClickListener {
//    fun onClick(product: Product)
//}



