package org.sopt.androidseminar1.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import org.sopt.androidseminar1.R

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String){
        Glide.with(imageView.context)
            .load(url)
            .error(R.drawable.ic_launcher_foreground)
            .circleCrop()
            .into(imageView)
    }
}