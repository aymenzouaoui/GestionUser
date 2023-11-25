package tn.esprit.greenworld.ui.gestionUser

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.greenworld.databinding.ActivityUserValidationBinding

class User_Validation :AppCompatActivity(){
    private  lateinit var binding: ActivityUserValidationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUserValidationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnValidation.setOnClickListener {
            startActivity(Intent(this, User_ValidationCode::class.java))
        }

    }


}