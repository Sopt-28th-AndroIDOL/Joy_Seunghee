# Joy_Seunghee

## Seminar Week4 Assignment (LV1)

### 🎀 구현해보기 🎀

💙회원가입

<img src="https://user-images.githubusercontent.com/81505421/118391269-67db1180-b66e-11eb-81df-bfb9a721b56d.gif"  width="200">

💙로그인

<img src="https://user-images.githubusercontent.com/81505421/118391262-63aef400-b66e-11eb-9350-ebb59ff9e07a.gif"  width="200">


💙Postman 테스트

* 로그인 성공

<img src="https://user-images.githubusercontent.com/81505421/118391160-da97bd00-b66d-11eb-8c80-9ad3314cb4a1.PNG"  width="700">

* 회원가입 중복(에뮬레이터에서 회원가입 완료)

<img src="https://user-images.githubusercontent.com/81505421/118391167-dff50780-b66d-11eb-8ce3-f32ecd9b8845.PNG"  width="700">



### 🎀 Interface 🎀
```kotlin
interface SoptService {
    @POST("/login/signin")  //signin interface
    fun postLogin(
        @Body body: RequestLoginData
    ) : Call<ResponseLoginData>

    @POST("/login/signup")  //signup interface
    fun postSignUp(
        @Body body: RequestSignUpData
    ) : Call<ResponseSignUpData>
}
```

### 🎀 구현체 🎀
```kotlin
object ServiceCreator {
    private const val BASE_URL = "http://cherishserver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val soptService: SoptService = retrofit.create(SoptService::class.java)
}
```
### 🎀 call back 🎀
💙SignInActivity

```kotlin
//로그인 서버 통신-----------------------------------
private fun requestLogin() {
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
```

```kotlin
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
```

💙SignUpActivity
```kotlin
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
```

```kotlin
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
```


* 패키징
<img src="https://user-images.githubusercontent.com/81505421/118391162-dd92ad80-b66d-11eb-9e53-0f6b52dc8118.PNG"  width="200">


### 🎀 성장 🎀

✏ 중간고사 시험기간 동안 이해 못한 채로 얼레벌레 했던 과제들을 다시 복습하고 이해하면서 재정비해보았다
(각종 네이밍 재설정!!)
✏ 3차 세미나 복습을 하면서 디자인도 바꿔보고, Figma를 활용하여 icon, color를 넣어봤다!
✏ intent를 앞에서 정의해줄 경우, by lazy 통해 startActivity(toHomeIntent) 하는 순간에 미리 설정해둔 값으로 초기화가 되도록 해준다!
(var는 lateinit, val는 by lazy)

