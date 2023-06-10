package org.sopt.androidseminar.presentation.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.androidseminar.api.ServiceCreator
import org.sopt.androidseminar.data.request.RequestLoginData
import org.sopt.androidseminar.data.response.ResponseLoginData
import org.sopt.androidseminar.presentation.signup.SignUpActivity
import org.sopt.androidseminar.databinding.ActivitySignInBinding
import org.sopt.androidseminar.presentation.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private val toHomeIntent by lazy { Intent(this@SignInActivity, HomeActivity::class.java) }
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

    private fun requestLogin() {
        //로그인 서버 통신-----------------------------------
        val requestLoginData =
            RequestLoginData(
                id = binding.etId.text.toString(),
                password = binding.etPw.text.toString()
            )
        //사용자의 정보 받아오기
        val call: Call<ResponseLoginData> = ServiceCreator.soptService
            .postLogin(requestLoginData)
        //비동기 작업 후 동작할 Callback 등록
        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                //네트워크 통신 성공 시
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(this@SignInActivity, data?.user_nickname+"님 안녕하세요", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(toHomeIntent)
                } else {
                    //에러 발생의 경우
                    Toast.makeText(this@SignInActivity, "로그인 에러 발생!", Toast.LENGTH_SHORT).show()
                }
            }

            //네트워크 통신 실패 시 retrofit이 하는 일
            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }

    private fun loginButtonClickEvent() {
        binding.btnLogin.setOnClickListener {
            val userID = binding.etId.text.toString()
            val userPW = binding.etPw.text.toString()
            if (userID.isNullOrBlank() || userPW.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                requestLogin()
            }
        }
    }

    private fun signUpButtonClickEvent() {
        binding.tvSignUpBtn.setOnClickListener {
            val toSignUpIntent = Intent(this@SignInActivity, SignUpActivity::class.java)
            signUpActivityLauncher.launch(toSignUpIntent)
        }

    }
}