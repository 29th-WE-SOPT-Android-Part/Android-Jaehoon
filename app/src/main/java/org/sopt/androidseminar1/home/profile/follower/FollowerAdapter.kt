package org.sopt.androidseminar1.home.profile.follower

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.androidseminar1.databinding.ItemFollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val followerList = mutableListOf<Follower>()

    class FollowerViewHolder (private val binding : ItemFollowerListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data : Follower) {
            binding.tvFollowerName.text = data.name
            binding.tvFollowerIntroduction.text = data.introduction

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        Glide.with(parent)
            .load("https://www.riotgames.com/darkroom/2880/656220f9ab667529111a78aae0e6ab9f:d1a7c6d0384f2edf9672d9369a8e9083/01-logo.png")
            .circleCrop()
            .into(binding.ivFollowerProfile)

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount() = followerList.size
}