package tn.esprit.greenworld.adapters.User

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import tn.esprit.greenworld.R
import tn.esprit.greenworld.models.User

class UserListAdapter(private val onItemClick: (User) -> Unit) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var userList: List<User> = ArrayList()

    fun setUserList(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        // Chargez l'image dans l'ImageView avec Picasso
        Picasso.get().load(user.imageRes).into(holder.imageView)
        holder.bind(user)

        holder.itemView.setOnClickListener {
            onItemClick.invoke(user)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userNameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(user: User) {
            userNameTextView.text = user.userName

            Glide.with(itemView)
                .load(user.imageRes)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_apple)
                        .error(R.drawable.ellipse_background)
                        .diskCacheStrategy(DiskCacheStrategy.ALL) // Caching strategy
                )
                .into(imageView)
        }
    }
}
