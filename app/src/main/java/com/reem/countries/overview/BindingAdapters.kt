package com.reem.countries.overview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.reem.countries.R
import com.reem.countries.network.Flag



@BindingAdapter("imageUrl")
fun ImageView.loadSvg(imageUri: String?) {
    imageUri?.let {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
            .build()

        this.load(imageUri, imageLoader) {
            crossfade(true)
            crossfade(500)
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Flag>?) {

    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}