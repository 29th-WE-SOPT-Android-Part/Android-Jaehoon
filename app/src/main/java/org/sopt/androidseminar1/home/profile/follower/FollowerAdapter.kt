package org.sopt.androidseminar1.home.profile.follower

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.androidseminar1.User
import org.sopt.androidseminar1.databinding.ItemFollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val followerList = mutableListOf<Follower>()

    class FollowerViewHolder (private val binding : ItemFollowerListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data : Follower) {

            binding.user = data
            binding.executePendingBindings()

            itemView.setOnClickListener {
                val intent = Intent(itemView?.context, FollowerDetailActivity::class.java)
                    .putExtra("image", data.image)
                    .putExtra("name", data.name)
                    .putExtra("introduction", data.introduction)
                startActivity(itemView.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount() = followerList.size
}