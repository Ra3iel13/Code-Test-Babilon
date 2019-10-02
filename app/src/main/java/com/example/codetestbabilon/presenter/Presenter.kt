package com.example.codetestbabilon.presenter

import Post_Title
import android.util.Log
import com.example.codetestbabilon.network.PostRequest
import com.example.codetestbabilon.network.RetrofitInstances
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter (_view: ViewInterface): PresenterInterface {
    private var view: ViewInterface? = _view
    private lateinit var model: Post_Title
    override fun getTopPost() {
        makeRetrofitCall()

    }

    override fun onDestroy() {
        view=null
    }
    private fun makeRetrofitCall(){

        val postRequest = RetrofitInstances().retrofitInstances.create(PostRequest::class.java)
        val call = postRequest.getPost()
        call.enqueue(object : Callback<List<Post_Title>> {

            override fun onFailure(call: Call<List<Post_Title>>, t: Throwable) {
                Log.d("News Error ", ""+t.message)
            }

            override fun onResponse(call: Call<List<Post_Title>>, response: Response<List<Post_Title>>) {
                val res = response.body()
                view?.showTopPost(res!!)
            }

        })
    }
}