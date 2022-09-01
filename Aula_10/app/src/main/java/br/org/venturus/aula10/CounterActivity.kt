package br.org.venturus.aula10

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CounterActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        val counterText = savedInstanceState?.getString(KEY_COUNTER) ?: "0"
        textView = findViewById(R.id.textView)
        textView.text = counterText

        findViewById<Button>(R.id.button).setOnClickListener {
            val currentValue = textView.text.toString().toInt()
            val result = currentValue + 1
            textView.text = result.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val counterText = textView.text.toString()
        outState.putString(KEY_COUNTER, counterText)
    }

    companion object {

        private const val KEY_COUNTER = "key_counter"
    }
}