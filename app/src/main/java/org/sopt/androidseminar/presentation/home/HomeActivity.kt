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
                        reposName = "AndroidSeminarAndroidSeminarAndroidSeminarAndroidSeminar",
                        aboutRepos = "말줄임표 보이려면 width를 match-parent로 해야돼!",
                        language = "kotlin"
                    ),
                    GithubReposInfo(
                        reposName = "SeminarGitTest",
                        aboutRepos = "깃 사용 전 테스트를 위해 만든 레포지터리",
                        language = "Java"
                    ),
                    GithubReposInfo(
                        reposName = "AwesomeRobotProject",
                        aboutRepos = "깃뿌 스터디에서 만들어본 로봇제작 레포지터리",
                        language = "kotlin"
                    ),
                    GithubReposInfo(
                        reposName = "SeungHee",
                        aboutRepos = "사용자가 처음으로 만들어본 레포지터리",
                        language = "C"
                    ),
                    GithubReposInfo(
                        reposName = "AlarmClockProject_ArduinoUno",
                        aboutRepos = "학교 전공 과제 아두이노 아무것도 모르겠음",
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