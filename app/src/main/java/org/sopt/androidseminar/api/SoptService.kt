package org.sopt.androidseminar.api

import org.sopt.androidseminar.data.request.RequestLoginData
import org.sopt.androidseminar.data.request.RequestSignUpData
import org.sopt.androidseminar.data.response.ResponseLoginData
import org.sopt.androidseminar.data.response.ResponseSignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
//1서비스당 1인터페이스
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