package tn.esprit.greenworld.ui.gestionUser


import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.greenworld.databinding.ActivityMainBinding


class main_activity :AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rootView = window.decorView.rootView
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        // Initialisation des TextWatchers, si nécessaire
        // initTextWatchers()

        // Gestion du clic sur le bouton "S'inscrire"
        binding.frame2.setOnClickListener {
              startActivity(Intent(this, LoginActivity::class.java))
             }

        // Gestion du clic sur le bouton "S'inscrire"
        binding.frame3.setOnClickListener {
            startActivity(Intent(this, User_Register::class.java))

        }
    }
}