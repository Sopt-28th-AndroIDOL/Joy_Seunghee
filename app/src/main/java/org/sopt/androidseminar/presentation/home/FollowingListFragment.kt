package org.sopt.androidseminar.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidseminar.data.FollowingUserInfo
import org.sopt.androidseminar.databinding.FragmentFollowingListBinding

class FollowingListFragment : Fragment() {

    private var _binding: FragmentFollowingListBinding? = null
    private val binding get() =_binding ?: error("View 를 참조하기 위해 binding 이 초기화 되지 않았습니다.")

    private val followingListAdapter: FollowingListAdapter by lazy{FollowingListAdapter()}

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.followUserList.adapter = followingListAdapter

        followingListAdapter.followingUserList.addAll(
                listOf<FollowingUserInfo>(
                    FollowingUserInfo(
                        userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                        userName = "Joy"
                    ),
                    FollowingUserInfo(
                        userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                        userName = "Semi"
                    ),
                    FollowingUserInfo(
                        userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                        userName = "Rimi"
                    ),
                    FollowingUserInfo(
                        userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                        userName = "Lucy"
                    )
                )
        )

        followingListAdapter.notifyDataSetChanged()  //데이터가 바뀌었으니 다시 설정해줘!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}