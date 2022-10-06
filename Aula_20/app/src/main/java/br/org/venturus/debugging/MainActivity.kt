package br.org.venturus.debugging

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText

    private lateinit var messageButton: Button

    private lateinit var textMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.edittext_name)
        messageButton = findViewById(R.id.button_show_message)

        val name = editTextName.text.toString()
        messageButton.setOnClickListener {
            textMessage.text = name
        }

        textMessage.addTextChangedListener { text ->
            if (text?.isBlank() == true) {
                messageButton.visibility = View.INVISIBLE
            }
        }
    }
}