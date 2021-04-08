package org.sopt.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidseminar.databinding.ActivityMainBinding
import org.sopt.androidseminar.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()
    }

    private fun initButtonClickEvent() {
        binding.signButton.setOnClickListener {
            val toHomeIntent2 = Intent(this@SignupActivity, HomeActivity::class.java)  //초기 signupActivity로 돌아간다? 종료?
            val userName = binding.editName.text
            val userID = binding.editGithubID.text
            val userPW = binding.editPW.text
            if (userName.isNullOrBlank() || userID.isNullOrBlank() || userPW.isNullOrBlank()) {
                Toast.makeText(this@SignupActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                toHomeIntent2.putExtra("userName", userName)
                toHomeIntent2.putExtra("userID", userID)
                startActivity(toHomeIntent2)
                //putExtra로 모든 값을 intent에 넣어 전달, SingUpActivity로 돌아가도록 종료
            }
        }
    }

}