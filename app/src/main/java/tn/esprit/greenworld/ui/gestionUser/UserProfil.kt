package tn.esprit.greenworld.ui.gestionUser

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import tn.esprit.greenworld.R

class UserProfil : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var textViewEmail: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profi)

        // Retrieve user details from intent
        val userId = intent.getStringExtra("userId")
        val userName = intent.getStringExtra("userName")
        val userEmail = intent.getStringExtra("userEmail")
        val userImageRes = intent.getStringExtra("userImageRes")

        // Initialize TextViews and ImageView
        textViewName = findViewById(R.id.textViewName)
        textViewEmail = findViewById(R.id.textViewEmail)
        imageView = findViewById(R.id.imageViewProfile)

        // Set user details to UI
        textViewName.text = userName
        textViewEmail.text = userEmail

        // Load user image using Glide
        Glide.with(this)
            .load(userImageRes)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_apple)
                    .error(R.drawable.ellipse_background)
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // Caching strategy
            )
            .into(imageView)
    }
}
