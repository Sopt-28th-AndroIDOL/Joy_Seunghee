package org.sopt.androidseminar

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ReposFragment : Fragment() {
    private var _binding: FragmentReposBinding? = null
    private val binding get() =_binding ?: error("View 를 참조하기 위해 binding 이 초기화 되지 않았습니다.")

    private lateinit var reposAdapter: ReposAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val _binding = FragmentReposBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reposAdapter = ReposAdapter()

        binding.reposList.adapter = ReposAdapter

        reposAdapter.reposList.addAll(
                listOf<ReposInfo>(
                        ReposInfo(
                                reposName = "이름을길게길게길게길게길게길게길게길게어쩌구저쩌구",
                                aboutRepos = "설명을길게길게길게길게길게길게길게길게어쩌구저쩌구",
                                language = "kotlin"
                        ),
                        ReposInfo(
                                reposName = "이름",
                                aboutRepos = "설명",
                                language = "kotlin"
                        ),
                        ReposInfo(
                                reposName = "이름",
                                aboutRepos = "설명",
                                language = "kotlin"
                        ),
                        ReposInfo(
                                reposName = "이름",
                                aboutRepos = "설명",
                                language = "kotlin"
                        ),
                        ReposInfo(
                                reposName = "이름",
                                aboutRepos = "설명",
                                language = "kotlin"
                        )
                )
        )

        reposAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}