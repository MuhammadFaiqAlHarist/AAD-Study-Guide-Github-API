package com.faiq.github.ui.listuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faiq.github.data.UsersResponseItem
import com.faiq.github.databinding.RowItemBinding

class ListAdapter(private var githublist: List<UsersResponseItem>) : RecyclerView.Adapter<ListAdapter.ListUserViewHolder>(){

        inner class ListUserViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder = ListUserViewHolder(
        RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        val githublist = githublist[position]
        holder.binding.apply {
            tvTitle.text = githublist.login
            tvSubtitle.text = githublist.url

            Glide.with(imgRaw)
                .load(githublist.avatarUrl)
                .into(imgRaw)
        }
    }

    override fun getItemCount(): Int {
        return githublist.size
    }
}