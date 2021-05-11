package org.sopt.androidseminar.api

import org.sopt.androidseminar.data.RequestLoginData
import org.sopt.androidseminar.data.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("/login/signin")
    fun postLogin(
            @Body body: RequestLoginData
    ) : Call<ResponseLoginData>
}