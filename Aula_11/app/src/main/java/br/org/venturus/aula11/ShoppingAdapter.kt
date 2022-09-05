package br.org.venturus.aula11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.org.venturus.aula11.databinding.ItemShoppingBinding

class ShoppingAdapter(
    private val list: List<Product>,
    private val onItemClicked: (Product) -> Unit
) : RecyclerView.Adapter<ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding =
            ItemShoppingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(binding)
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

class ShoppingViewHolder(private val binding: ItemShoppingBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Product) {
        binding.apply {
            imageviewItemPic.setImageResource(product.image)
            textviewItemName.text = product.name
            textviewItemBrand.text = product.brand
        }
    }
}

// interface funcional
//fun interface ItemClickListener {
//    fun onClick(product: Product)
//}
