package br.org.venturus.aula13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.org.venturus.aula13.databinding.ActivityUserProfileBinding

internal class UserProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        viewModel.profileInfo.observe(this, ::updateUi)
        viewModel.loadProfile()
    }

    private fun updateUi(userInfo: UserInfo) = binding.run {
        imageviewHeader.setImageResource(userInfo.headerImage)
        imageviewProfile.setImageResource(userInfo.profileImage)
        textviewUsername.setText(userInfo.name)
        textviewDescription.setText(userInfo.description)
        textviewBio.setText(userInfo.bio)
    }
}