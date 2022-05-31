package com.oliferov.test_for_reshenie_soft.presentation.screen.listnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oliferov.test_for_reshenie_soft.databinding.NewsItemBinding
import com.oliferov.test_for_reshenie_soft.domain.model.News

class NewsListAdapter : ListAdapter<News, NewsListViewHolder>(NewsListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val binding = NewsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val news = getItem(position)
        with(news){
            with(holder.binding){
                tvTitle.text = title
                tvBody.text = body
                tvId.text = id.toString()
                tvUid.text = userId.toString()
            }
        }
    }
}

class NewsListDiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }

}

class NewsListViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root)


