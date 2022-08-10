package com.faiq.github.ui.searchuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faiq.github.data.UsersResponseItem
import com.faiq.github.databinding.ActivityListUserBinding
import com.faiq.github.databinding.RowItemBinding

class SearchAdapter(private val searchGithub: List<UsersResponseItem>) :
    RecyclerView.Adapter<SearchAdapter.SearchUserViewHolder>() {

    inner class SearchUserViewHolder(val binding: RowItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchUserViewHolder(
        RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SearchUserViewHolder, position: Int) {
        val searchGithub = searchGithub[position]
        holder.binding.apply {
            tvTitle.text = searchGithub.login
            tvSubtitle.text = searchGithub.url

            Glide.with(imgRaw).load(searchGithub.avatarUrl).into(imgRaw)
        }
    }

    override fun getItemCount(): Int = searchGithub.size
}