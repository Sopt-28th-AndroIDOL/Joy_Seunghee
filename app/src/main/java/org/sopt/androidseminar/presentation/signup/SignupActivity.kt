package org.sopt.androidseminar.presentation.signup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.androidseminar.api.ServiceCreator
import org.sopt.androidseminar.data.request.RequestSignUpData
import org.sopt.androidseminar.data.response.ResponseSignUpData
import org.sopt.androidseminar.databinding.ActivitySignupBinding
import org.sopt.androidseminar.presentation.signin.SignInActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private val toSignInIntent by lazy {Intent(this@SignUpActivity, SignInActivity::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signUpButtonClickEvent()
    }
    //회원가입 서버 통신-----------------------------------
    private fun requestSignUp() {
        val requestSignUpData =
            RequestSignUpData(
                id = binding.etGithubId.text.toString(),
                password = binding.etPw.text.toString(),
                sex = binding.etSex.text.toString(),
                nickname = binding.etNickname.text.toString(),
                phone = binding.etPhone.text.toString(),
                birth = binding.etBirth.text.toString()
            )
        //사용자의 정보 받아오기
        val call: Call<ResponseSignUpData> = ServiceCreator.soptService
            .postSignUp(requestSignUpData)
        //비동기 작업 후 동작할 Callback 등록
        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                //네트워크 통신 성공 시
                if (response.isSuccessful) {
                    Toast.makeText(this@SignUpActivity, "회원가입 완료!", Toast.LENGTH_SHORT).show()
                    setResult(Activity.RESULT_OK, toSignInIntent)
                    finish()
                } else {
                    //에러 발생의 경우
                    Toast.makeText(this@SignUpActivity, "회원가입 에러 발생!", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            //네트워크 통신 실패 시 retrofit이 하는 일
            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }

    private fun signUpButtonClickEvent() {
        binding.btnSignUp.setOnClickListener {
            val userID = binding.etGithubId.text.toString()
            val userPW = binding.etPw.text.toString()
            val userSex = binding.etSex.text.toString()
            val userNickname = binding.etNickname.text.toString()
            val userPhone = binding.etPhone.text.toString()
            val userBirth = binding.etBirth.text.toString()
            if (userID.isNullOrBlank() || userPW.isNullOrBlank() || userSex.isNullOrBlank() || userNickname.isNullOrBlank() || userPhone.isNullOrBlank() || userBirth.isNullOrBlank()) {
                Toast.makeText(this@SignUpActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                toSignInIntent.putExtra("userID", userID)
                toSignInIntent.putExtra("userPW", userPW)
                toSignInIntent.putExtra("userSex", userSex)
                toSignInIntent.putExtra("userNickname", userNickname)
                toSignInIntent.putExtra("userPhone", userPhone)
                toSignInIntent.putExtra("userBirth", userBirth)
                requestSignUp()
            }
        }
    }


}