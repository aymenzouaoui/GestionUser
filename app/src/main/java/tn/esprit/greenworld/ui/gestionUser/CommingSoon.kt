package tn.esprit.greenworld.ui.gestionUser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.greenworld.databinding.ActivityCommingSoonBinding

class CommingSoon : AppCompatActivity() {
    lateinit var binding:ActivityCommingSoonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommingSoonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the root view to be used as the parent for Snackbar
        val rootView = window.decorView.rootView
        binding.imageView5.setOnClickListener {

            finish()
        }
    }
}