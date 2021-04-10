package org.sopt.androidseminar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidseminar.databinding.ActivitySignInBinding
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

}