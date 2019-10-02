package com.example.codetestbabilon.view

import Post_Title
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codetestbabilon.R
import kotlinx.android.synthetic.main.row.view.*

class PostAdaptor (private val postTitle: List<Post_Title> , private val listener: OnPostClickListener): RecyclerView.Adapter<PostAdaptor.PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        )

    }

    override fun getItemCount(): Int {
        return postTitle.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.tvTitle.text=postTitle[position].title
        holder.bind(postTitle,listener)

    }


    class PostViewHolder (view: View) : RecyclerView.ViewHolder(view),View.OnClickListener{
        override fun onClick(p0: View?) {
        }
        fun bind(results: List<Post_Title>, listener: OnPostClickListener) {
            itemView.setOnClickListener{
                listener.onMovieClickListener(results)
            }

        }


        val tvTitle = view.tv_title1
    }
}

interface OnPostClickListener{
    fun onMovieClickListener(post: List<Post_Title>)


}