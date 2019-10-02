package com.example.codetestbabilon.network

import Post_Title
import retrofit2.Call
import retrofit2.http.GET

interface PostRequest {
    @GET("users")
    fun getPost(): Call<List<Post_Title>>
}