package org.sopt.androidseminar1.home.profile.follower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import org.sopt.androidseminar1.R
import org.sopt.androidseminar1.databinding.ActivityFollowerDetailBinding

class FollowerDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFollowerDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_follower_detail)

        init()
    }

    private fun init() {
        val image = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val introduction = intent.getStringExtra("introduction")

        Glide.with(this)
            .load(image)
            .into(binding.ivFollowerDetailProfile)
        binding.tvFollowerDetailName.text = name
        binding.tvFollowerDetailIntroduction.text = introduction
    }
}