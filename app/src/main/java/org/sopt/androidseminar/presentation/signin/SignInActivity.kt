package org.sopt.androidseminar.presentation.signin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.androidseminar.presentation.signup.SignupActivity
import org.sopt.androidseminar.databinding.ActivitySignInBinding
import org.sopt.androidseminar.presentation.home.HomeActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private val signUpActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ){
            //signUp에서 데이터 받아오기
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginButtonClickEvent()
        signUpButtonClickEvent()
    }

    private fun loginButtonClickEvent() {
        binding.btnLogin.setOnClickListener {
            val userID = binding.etId.text.toString()
            val userPW = binding.etPw.text.toString()
            if (userID.isNullOrBlank() || userPW.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SignInActivity, "로그인성공", Toast.LENGTH_SHORT).show()
                val toHomeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
                startActivity(toHomeIntent)
            }
        }
    }

    private fun signUpButtonClickEvent() {
        binding.tvSignUpBtn.setOnClickListener {
            val toSignUpIntent = Intent(this@SignInActivity, SignupActivity::class.java)
            signUpActivityLauncher.launch(toSignUpIntent)
        }

    }
}