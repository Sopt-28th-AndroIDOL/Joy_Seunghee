package org.sopt.androidseminar.presentation.signup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidseminar.databinding.ActivitySignupBinding
import org.sopt.androidseminar.presentation.signin.SignInActivity

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signUpButtonClickEvent()
    }

    private fun signUpButtonClickEvent() {
        binding.btnSignUp.setOnClickListener {
            val toSignInIntent = Intent(this@SignupActivity, SignInActivity::class.java)
            val userName = binding.etName.text.toString()
            val userID = binding.etGithubId.text.toString()
            val userPW = binding.etPw.text.toString()
            if (userName.isNullOrBlank() || userID.isNullOrBlank() || userPW.isNullOrBlank()) {
                Toast.makeText(this@SignupActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                toSignInIntent.putExtra("userName", userName)
                toSignInIntent.putExtra("userID", userID)
                toSignInIntent.putExtra("userPW", userPW)
                setResult(Activity.RESULT_OK, toSignInIntent)
                finish()
            }
        }
    }

}