package com.yoesuv.mycoroutines.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingConverters {

    companion object {

        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: AppCompatImageView, imageUrl: String) {
            Glide.with(imageView)
                .load(imageUrl)
                .into(imageView)
        }

    }

}