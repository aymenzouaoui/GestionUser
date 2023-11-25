package tn.esprit.greenworld.ui.gestionUser

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.greenworld.databinding.ActivityUserRentialiseMotPasseBinding

class User_RentialiseMotPasse:AppCompatActivity() {

   private lateinit var binding: ActivityUserRentialiseMotPasseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityUserRentialiseMotPasseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.btnReturn.setOnClickListener {
            finish()
        }

    }
}