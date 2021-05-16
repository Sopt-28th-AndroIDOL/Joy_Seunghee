package org.sopt.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.androidseminar.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private val signUpActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()
    }

    private fun initButtonClickEvent() {
        binding.loginButton.setOnClickListener {
            val intent = Intent(this@SignInActivity, HomeActivity::class.java)
            val userID = binding.editID.text.toString()
            val userPW = binding.editPW.text.toString()  //toString이 뭔지 좀더 알아보기
            if (userID.isNullOrBlank() || userPW.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SignInActivity, "로그인성공", Toast.LENGTH_SHORT).show()
                val toHomeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
                toHomeIntent.putExtra("userID",userID)
                startActivity(toHomeIntent)
            }
        }

        binding.signButton.setOnClickListener {
            val toSignIntent = Intent(this@SignInActivity, SignupActivity::class.java)
            signUpActivityLauncher.launch(toSignIntent)
        }

    }
}