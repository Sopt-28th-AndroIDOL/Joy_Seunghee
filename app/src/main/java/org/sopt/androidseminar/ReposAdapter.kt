package org.sopt.androidseminar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.databinding.ItemFollowUserBinding
import org.sopt.androidseminar.databinding.ItemReposBinding

class ReposAdapter : RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    val reposList = mutableListOf<ReposInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val binding = ItemReposBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return ReposViewHolder(binding)
    }

    override fun getItemCount(): Int = reposList.size

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.onBind(reposList[position])
    }

    class ReposViewHolder(
            private val binding: ItemReposBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(reposInfo: ReposInfo) {
            binding.reposName.text = reposInfo.reposName
            binding.aboutRepos.text = reposInfo.aboutRepos
            binding.language.text = reposInfo.language
        }
    }
}