package org.sopt.androidseminar1.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.sopt.androidseminar1.R
import org.sopt.androidseminar1.User
import org.sopt.androidseminar1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        init()
        initBtn()
    }

    private fun init() {
        val followerFragment = FollowerFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fc_home_list, followerFragment)
            .commit()

        binding.user = User("조재훈", "26", "INFJ",
            "안드파트 최고!\n\n안드파트 최고!\n\n안드파트 최고!\n\n안드파트 최고!\n\n안드파트 최고!")
    }

    private fun initBtn() {
        binding.btnGit.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jaehoon-jo"))
            startActivity(intent)
        }

        binding.btnFollowerList.setOnClickListener {
            transFragment(FOLLOWER_BTN)
        }

        binding.btnRepositoryList.setOnClickListener {
            transFragment(REPOSITORY_BTN)
        }
    }

    private fun transFragment(btn : Int) {
        val transaction = supportFragmentManager.beginTransaction()

        when(btn) {
            FOLLOWER_BTN -> {
                val followerFragment = FollowerFragment()
                transaction.replace(R.id.fc_home_list, followerFragment).commit()

            }
            REPOSITORY_BTN -> {
                val repositoryFragment = RepositoryFragment()
                transaction.replace(R.id.fc_home_list, repositoryFragment).commit()
            }
        }
    }

    companion object {
        const val FOLLOWER_BTN = 1
        const val REPOSITORY_BTN = 2
    }
}