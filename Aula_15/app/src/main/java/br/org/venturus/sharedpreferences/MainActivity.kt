package br.org.venturus.sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isFirstTime()) {
            showWelcomeDialog()
            updateFirstTime()
        }
    }

    private fun isFirstTime(): Boolean {
        /*val sharedPref = getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getBoolean(KEY_FIRST_TIME_APP, true)*/
        return runBlocking { dataStore.data.first()[KEY_FIRST_TIME_APP] } ?: true
    }

    private fun updateFirstTime() {
        lifecycleScope.launch {
            dataStore.edit { settings ->
                settings[KEY_FIRST_TIME_APP] = false
            }
        }

        /*val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean(KEY_FIRST_TIME_APP, false)
            apply()
        }*/
    }

    private fun showWelcomeDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.apply {
            setMessage(R.string.dialog_title).setTitle(R.string.dialog_message)
            setPositiveButton(android.R.string.ok) { _, _ -> /* Dismiss dialog */ }
            setCancelable(false)
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private companion object {

        private val KEY_FIRST_TIME_APP = booleanPreferencesKey("KEY_FIRST_TIME_APP")
    }
}
