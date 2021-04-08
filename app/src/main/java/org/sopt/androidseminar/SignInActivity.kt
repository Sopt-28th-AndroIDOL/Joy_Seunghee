package org.sopt.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidseminar.databinding.ActivityMainBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()
    }

    private fun initButtonClickEvent() {
        binding.loginButton.setOnClickListener {
            val userID = binding.editID.text
            val userPW = binding.editPW.text
            if (userID.isNullOrBlank() || userPW.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SignInActivity, "로그인성공", Toast.LENGTH_SHORT).show()
                val toHomeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
                toHomeIntent.putExtra("userID",userID)
                startActivity(toHomeIntent)//HomeActivity로 이동해지지가 않음......
            }
        }

        binding.signButton.setOnClickListener {
            val toSignIntent = Intent(this@SignInActivity, SignupActivity::class.java)
            startActivity(toSignIntent)  //registerActivityForResult 어떻게..
        }

    }
}