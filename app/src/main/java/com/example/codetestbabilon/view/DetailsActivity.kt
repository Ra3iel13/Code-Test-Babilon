package com.example.codetestbabilon.view

import Post_Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.codetestbabilon.R
import com.example.codetestbabilon.network.PostRequest
import com.example.codetestbabilon.network.RetrofitInstances
import kotlinx.android.synthetic.main.activity_details.*
import retrofit2.Call
import retrofit2.Response


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val intent=intent

        val postRequest = RetrofitInstances().retrofitInstances.create(PostRequest::class.java)
        val call =postRequest.getPost()
        call.enqueue(object :retrofit2.Callback<List<Post_Title>>{

            override fun onResponse(call: Call<List<Post_Title>>,
                response: Response<List<Post_Title>>) {
                val res =response.body()
                Log.d("MainActivyty",res!!.size.toString())
                tv_Title.text=res!![0].title
                tv_Post.text=res!![0].body
                tv_Author.text= res!![0].id.toString()
                tv_NumberOfComments.text=res!![0].userId.toString()

            }



            override fun onFailure(call: Call<List<Post_Title>>, t: Throwable) {

            }

        })

    }
}
