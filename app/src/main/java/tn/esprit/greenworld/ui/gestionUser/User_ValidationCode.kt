package tn.esprit.greenworld.ui.gestionUser

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.greenworld.databinding.ActivityUserValidationCodeBinding

class User_ValidationCode:AppCompatActivity() {

    private  lateinit var binding: ActivityUserValidationCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserValidationCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVerify.setOnClickListener {
            startActivity(Intent(this, User_ValidationCode::class.java))
        }

        binding.btnResendCode.setOnClickListener {
            startActivity(Intent(this, User_ValidationCode::class.java))
        }
    }
}