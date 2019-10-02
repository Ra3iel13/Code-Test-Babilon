package com.example.codetestbabilon

import Post_Title
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codetestbabilon.presenter.Presenter
import com.example.codetestbabilon.presenter.ViewInterface
import com.example.codetestbabilon.view.DetailsActivity
import com.example.codetestbabilon.view.OnPostClickListener
import com.example.codetestbabilon.view.PostAdaptor
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ViewInterface {
    private lateinit var presenter: Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = Presenter(this)


    }
    override fun showLoading() {
        progBar_Post.visibility = View.VISIBLE


    }

    override fun showTopPost(post: List<Post_Title>) {
        progBar_Post.visibility = View.GONE




        val adaptor: PostAdaptor = PostAdaptor(post!!, object : OnPostClickListener {
            override fun onMovieClickListener(post: List<Post_Title>) {
                val intent=Intent(this@MainActivity,DetailsActivity::class.java)
                startActivity(intent)
                sendToNextActivity()



            }


        })



        rv_List.layoutManager = LinearLayoutManager(this@MainActivity)
        rv_List.adapter = adaptor



    }
    fun sendToNextActivity() {


    }

}
