package org.sopt.androidseminar1.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar1.databinding.ItemRepositoryListBinding

class RepositoryAdpater : RecyclerView.Adapter<RepositoryAdpater.RepositoryViewHolder>() {
    val repositoryList = mutableListOf<Repository>()

    class RepositoryViewHolder (private val binding : ItemRepositoryListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: Repository) {
            binding.tvRepositoryTitle.text = data.title
            binding.tvRepositoryContent.text = data.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }

    override fun getItemCount(): Int = repositoryList.size
}