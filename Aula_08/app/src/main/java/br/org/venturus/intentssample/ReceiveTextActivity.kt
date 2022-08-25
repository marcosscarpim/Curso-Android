package br.org.venturus.intentssample

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReceiveTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_text)

        if (intent?.action == Intent.ACTION_SEND && intent?.type == "text/plain") {
            val text = intent?.getStringExtra(Intent.EXTRA_TEXT)
            val textView = findViewById<TextView>(R.id.textview_share)
            textView.text = text
        }
    }

    val bundle = Bundle().apply {
        putString("key", "1ddfs-454f")
        putInt("product-quantity", 3444)
        putFloat("price", 1222.5F)
    }
}