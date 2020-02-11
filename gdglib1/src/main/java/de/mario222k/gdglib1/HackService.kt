package de.mario222k.gdglib1

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface HackService {
    @POST("post")
    @FormUrlEncoded
    fun hack(@Field("name") name: String, @Field("password") password: String): Call<HackResponse>
}

class HackResponse