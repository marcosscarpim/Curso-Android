package br.org.venturus.internetrequest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.org.venturus.internetrequest.databinding.ActivityJokeBinding
import br.org.venturus.internetrequest.remote.model.JokeResponse
import coil.load

class JokeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJokeBinding

    private lateinit var viewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(JokeViewModel::class.java)
        viewModel.loadJoke()
        viewModel.jokeData.observe(this, ::updateJokeData)

        initComponents()
    }

    private fun initComponents() {
        binding.buttonNewJoke.setOnClickListener { viewModel.loadJoke() }
        binding.imageviewLogo.load(VNT_LOGO_URL)
    }

    private fun updateJokeData(jokeData: JokeResponse) {
        binding.apply {
            textviewSetup.text = jokeData.setup
            textviewPunchline.text = jokeData.punchline
        }
    }

    private companion object {
        private const val VNT_LOGO_URL =
            "https://www.venturus.org.br/wp-content/uploads/2020/12/Simbolo_Colorido.png"
    }
}