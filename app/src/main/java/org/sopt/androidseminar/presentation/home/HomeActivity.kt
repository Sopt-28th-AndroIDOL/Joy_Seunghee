package org.sopt.androidseminar.presentation.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.androidseminar.data.GithubReposInfo
import org.sopt.androidseminar.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var githubReposAdapter: GithubReposAdapter
    private val userInfoActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moreButtonClickEvent()

        initReposListRecyclerView()
    }

    private fun initReposListRecyclerView() {
        githubReposAdapter = GithubReposAdapter()

        binding.rvReposList.adapter = githubReposAdapter

        githubReposAdapter.githubReposList.addAll(
                listOf<GithubReposInfo>(
                    GithubReposInfo(
                        reposName = "AndroidSeminar",
                        aboutRepos = "SOPT 안드로이드 파트 세미나 과제 연습하는 레포지터리",
                        language = "kotlin"
                    ),
                    GithubReposInfo(
                        reposName = "SeminarGitTest",
                        aboutRepos = "깃 사용 전 테스트를 위해 만든 레포지터리",
                        language = "Java"
                    ),
                    GithubReposInfo(
                        reposName = "AwesomeRobotProject",
                        aboutRepos = "깃뿌 스터디에서 멘토님과 만들어본 로봇제작 레포지터리",
                        language = "kotlin"
                    ),
                    GithubReposInfo(
                        reposName = "SeungHee",
                        aboutRepos = "사용자가 처음으로 만들어본 레포지터리",
                        language = "C"
                    ),
                    GithubReposInfo(
                        reposName = "RepoRepoRepos",
                        aboutRepos = "이건 그냥 다섯번째 칸을 위해 만들었다 치는 레포지터리",
                        language = "Arduino"
                    )
                )
            )
        }


    private fun moreButtonClickEvent() {
        binding.btnMore.setOnClickListener {
            val intent = Intent(this@HomeActivity, UserInfoActivity::class.java)
            userInfoActivityLauncher.launch(intent)
        }
    }
}