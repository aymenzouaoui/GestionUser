package tn.esprit.greenworld.ui.gestionUser

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.esprit.greenworld.R
import tn.esprit.greenworld.adapters.User.UserListAdapter
import tn.esprit.greenworld.utils.RetrofitImp
import tn.esprit.greenworld.utils.UserInterface
import tn.esprit.greenworld.models.User

class UserListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        Picasso.get().setLoggingEnabled(true)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserListAdapter { user ->
            navigateToUserProfile(user)
        }
        recyclerView.adapter = adapter

        // Initialize Retrofit
        val retrofit = RetrofitImp.buildRetrofit()

        // Create an instance of the service
        val apiService = retrofit.create(UserInterface::class.java)

        // Call the method to retrieve the list of users
        val call: Call<List<User>> = apiService.getAllUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val userList: List<User>? = response.body()
                    if (userList != null) {
                        adapter.setUserList(userList)
                    }
                } else {
                    // Handle the error
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // Handle the error
            }
        })
    }
    private fun navigateToUserProfile(user: User) {
        val intent = Intent(this, UserProfil::class.java)
        intent.putExtra("userId", user._id)
        intent.putExtra("userName", user.userName)
        intent.putExtra("userEmail", user.userName)
        intent.putExtra("userImageRes", user.imageRes)
        // Add other user attributes as needed
        startActivity(intent)
    }
}
