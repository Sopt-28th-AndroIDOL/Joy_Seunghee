package org.sopt.androidseminar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.androidseminar.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SignUpLog", "onCreate")
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()
    }

    private fun initButtonClickEvent() {
        binding.signupButton.setOnClickListener {
            val toSignInIntent = Intent(this@SignupActivity, SignInActivity::class.java)
            val userName = binding.editName.text.toString()
            val userID = binding.editGithubID.text.toString()
            val userPW = binding.editPW.text.toString()
            if (userName.isNullOrBlank() || userID.isNullOrBlank() || userPW.isNullOrBlank()) {
                Toast.makeText(this@SignupActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                toSignInIntent.putExtra("userID", userID)
                toSignInIntent.putExtra("userPW", userPW)
                setResult(Activity.RESULT_OK, toSignInIntent)
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("SignUpLog", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SignUpLog", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SignUpLog", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SignUpLog", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SignUpLog", "onDestroy")
    }

}