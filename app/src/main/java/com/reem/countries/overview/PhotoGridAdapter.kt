package com.reem.countries.overview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.reem.countries.databinding.GridViewItemBinding
import com.reem.countries.network.Flag


class PhotoGridAdapter : ListAdapter<Flag,
        PhotoGridAdapter.CountrysPhotoViewHolder>(DiffCallback) {


    class CountrysPhotoViewHolder(private var binding:
                                  GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto: Flag) {
            binding.photo = MarsPhoto
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
    ): PhotoGridAdapter.CountrysPhotoViewHolder {
        return CountrysPhotoViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))    }



    override fun onBindViewHolder(holder: PhotoGridAdapter.CountrysPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}