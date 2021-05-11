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
                        reposName = "이름1을길게길게길게길게길게길게길게길게어쩌구저쩌구",
                        aboutRepos = "설명1을길게길게길게길게길게길게길게길게어쩌구저쩌구",
                        language = "kotlin"
                    ),
                    GithubReposInfo(
                        reposName = "이름2",
                        aboutRepos = "설명2",
                        language = "kotlin"
                    ),
                    GithubReposInfo(
                        reposName = "이름3",
                        aboutRepos = "설명3",
                        language = "kotlin"
                    ),
                    GithubReposInfo(
                        reposName = "이름4",
                        aboutRepos = "설명4",
                        language = "kotlin"
                    ),
                    GithubReposInfo(
                        reposName = "이름5",
                        aboutRepos = "설명5",
                        language = "kotlin"
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