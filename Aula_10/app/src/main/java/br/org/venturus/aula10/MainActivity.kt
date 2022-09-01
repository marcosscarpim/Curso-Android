package br.org.venturus.aula10

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar_custom))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        findViewById<Button>(R.id.button).setOnClickListener {

            val isCheckbox1Checked = findViewById<CheckBox>(R.id.checkbox_option1).isChecked
            val isCheckbox2Checked = findViewById<CheckBox>(R.id.checkbox_option2).isChecked
            val isCheckbox3Checked = findViewById<CheckBox>(R.id.checkbox_option3).isChecked

            Log.d(
                TAG, "Checked - isCheckbox1Checked = $isCheckbox1Checked, " +
                    "isCheckbox2Checked = $isCheckbox2Checked, " +
                    "isCheckbox3Checked = $isCheckbox3Checked"
            )

            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
            val radioButtonId = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton? = radioGroup.findViewById(radioButtonId)

            Log.d(TAG, "Selected = ${radioButton?.text}")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.action_share -> {
                Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                true
            }
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    private companion object {

        private const val TAG = "MainActivity"
    }
}