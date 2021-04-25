package org.sopt.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.sopt.androidseminar.databinding.ActivityHomeBinding
import org.sopt.androidseminar.databinding.ActivitySignupBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var reposAdapter: ReposAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()

        reposAdapter = ReposAdapter()

        binding.reposList.adapter = reposAdapter

        reposAdapter.run {
            reposList.addAll(
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

            notifyDataSetChanged()
        }

    }

    private fun initButtonClickEvent() {
        binding.more.setOnClickListener {
            val intent = Intent(this@HomeActivity, UserInfoActivity::class.java)
            startActivity(intent)
        }
    }
}