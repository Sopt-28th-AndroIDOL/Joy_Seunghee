package org.sopt.androidseminar.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.data.FollowingUserInfo
import org.sopt.androidseminar.databinding.ItemFollowUserBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>() {

    val followingUserList = mutableListOf<FollowingUserInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingUserViewHolder {
        val binding = ItemFollowUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return FollowingUserViewHolder(binding)
    }

    override fun getItemCount(): Int = followingUserList.size

    override fun onBindViewHolder(holder: FollowingUserViewHolder, position: Int) {
        holder.onBind(followingUserList[position])
    }

    class FollowingUserViewHolder(
            private val binding: ItemFollowUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingUserInfo: FollowingUserInfo) {
            binding.tvFollowUserName.text = followingUserInfo.userName
        }
    }
}