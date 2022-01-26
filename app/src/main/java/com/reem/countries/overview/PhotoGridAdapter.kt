package com.reem.countries.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.reem.countries.databinding.GridViewItemBinding
import com.reem.countries.network.Flag

class PhotoGridAdapter : ListAdapter<Flag,
        PhotoGridAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding:
                                  GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(FlagPhoto: Flag) {
            binding.photo = FlagPhoto
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Flag>() {
        override fun areItemsTheSame(oldItem: Flag, newItem: Flag): Boolean {
            return newItem.name == oldItem.name
        }

        override fun areContentsTheSame(oldItem: Flag, newItem: Flag): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}