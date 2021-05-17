package org.sopt.androidseminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidseminar.databinding.FragmentFollowingListBinding

class FollowingListFragment : Fragment() {

    private var _binding: FragmentFollowingListBinding? = null
    private val binding get() =_binding ?: error("View 를 참조하기 위해 binding 이 초기화 되지 않았습니다.")

    private lateinit var followingListAdapter: FollowingListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val _binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followingListAdapter = FollowingListAdapter()

        binding.userList.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
                listOf<FollowingUserInfo>(
                        FollowingUserInfo(
                                userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                                userName = "Lydia"
                        ),
                        FollowingUserInfo(
                                userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                                userName = "Lljlk1"
                        ),
                        FollowingUserInfo(
                                userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                                userName = "kutfkuy6"
                        ),
                        FollowingUserInfo(
                                userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                                userName = "jg8"
                        )
                )
        )

        followingListAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}