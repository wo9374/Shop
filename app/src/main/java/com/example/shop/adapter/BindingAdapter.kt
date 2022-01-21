package com.example.shop.adapter

import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.shop.R

//Binding Adapter 는 메모리상에 올려서 사용해야 하기 때문에 Object 로 생성
object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String){
        Glide.with(imageView.context)
            .load(url)
            .error(R.drawable.ic_launcher_background)
            .circleCrop()
            .into(imageView)
    }
}