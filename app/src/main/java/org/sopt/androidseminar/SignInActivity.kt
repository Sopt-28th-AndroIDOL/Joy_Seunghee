package org.sopt.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.androidseminar.databinding.ActivityMainBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val signUpActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SignInLog", "onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()
    }

    private fun initButtonClickEvent() {
        binding.loginButton.setOnClickListener {
            val userID = binding.editID.text.toString()
            val userPW = binding.editPW.text.toString()  //toString이 뭔지 좀더 알아보기
            if (userID.isNullOrBlank() || userPW.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT)
                        .show()
            } else {
                Toast.makeText(this@SignInActivity, "로그인성공", Toast.LENGTH_SHORT)
                        .show()
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

    override fun onStart() {
        super.onStart()
        Log.d("SignInLog", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SignInLog", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SignInLog", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SignInLog", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SignInLog", "onDestroy")
    }
}