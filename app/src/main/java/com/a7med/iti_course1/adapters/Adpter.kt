package com.a7med.iti_course1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a7med.iti_course1.ui.MyClickItem
import com.a7med.iti_course1.databinding.UserListBinding
import com.a7med.iti_course1.modle.TimeLine
import com.squareup.picasso.Picasso

class Adpter(var post: List<TimeLine>, var Lisener: MyClickItem) :
    RecyclerView.Adapter<Adpter.ViewHolder>() {


    inner class ViewHolder(var binding: UserListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return post.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = post.get(position)
        holder.binding.firstName.text = "${data.firstname} ${data.lastname}"
        holder.binding.data.text = "${post[position].id}"
        holder.binding.post.text = post[position].email

        if (post[position].avatar.isNotEmpty()) {

            Picasso.get()
                .load(post[position].avatar)
                .into(holder.binding.imageVi)
        }
        // holder.binding.detlsBu.setOnClickListener {
        //     Lisener.clickItem(post[position],position)
        //     }
    }


}


