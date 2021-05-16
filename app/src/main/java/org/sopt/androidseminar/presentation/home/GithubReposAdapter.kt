package org.sopt.androidseminar.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.data.GithubReposInfo
import org.sopt.androidseminar.databinding.ItemReposBinding

class GithubReposAdapter : RecyclerView.Adapter<GithubReposAdapter.GithubReposViewHolder>() {

    val githubReposList = mutableListOf<GithubReposInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubReposViewHolder {
        val binding = ItemReposBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return GithubReposViewHolder(binding)
    }

    override fun getItemCount(): Int = githubReposList.size

    override fun onBindViewHolder(holder: GithubReposViewHolder, position: Int) {
        holder.onBind(githubReposList[position])
    }

    class GithubReposViewHolder(
            private val binding: ItemReposBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(githubReposInfo: GithubReposInfo) {
            binding.tvReposName.text = githubReposInfo.reposName
            binding.tvAboutRepos.text = githubReposInfo.aboutRepos
            binding.tvLanguage.text = githubReposInfo.language
        }
    }
}