package br.org.venturus.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.org.venturus.test.databinding.ActivityMainBinding
import br.org.venturus.test.math.Calculator

internal class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() = with(binding) {
        buttonAdd.setOnClickListener {
            if (areNumbersInserted()) {
                val first = edittextFirst.text.toString().toInt()
                val second = edittextSecond.text.toString().toInt()
                val result = calculator.sum(first, second)
                textviewResult.text = result.toString()
            }
        }
        buttonSub.setOnClickListener {
            if (areNumbersInserted()) {
                val first = edittextFirst.text.toString().toInt()
                val second = edittextSecond.text.toString().toInt()
                val result = calculator.sub(first, second)
                textviewResult.text = result.toString()
            }
        }
        buttonDivide.setOnClickListener {
            if (areNumbersInserted()) {
                val first = edittextFirst.text.toString().toDouble()
                val second = edittextSecond.text.toString().toDouble()
                val result = calculator.divide(first, second)
                textviewResult.text = result.toString()
            }
        }
    }

    private fun areNumbersInserted(): Boolean = with(binding) {
        edittextFirst.text.isNotEmpty() && edittextSecond.text.isNotEmpty()
    }
}