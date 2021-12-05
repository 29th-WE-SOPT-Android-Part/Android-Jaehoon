package org.sopt.androidseminar1.home.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import org.sopt.androidseminar1.GitServiceCreator
import org.sopt.androidseminar1.R
import org.sopt.androidseminar1.ResponseGitUserData
import org.sopt.androidseminar1.User
import org.sopt.androidseminar1.databinding.FragmentProfileBinding
import org.sopt.androidseminar1.home.profile.follower.FollowerFragment
import org.sopt.androidseminar1.home.profile.repository.RepositoryFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {
    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        init()

        return binding.root
    }

    private fun init() {
        initProfile()
        initBtn()

        val followerFragment = FollowerFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(R.id.fc_home_list, followerFragment)
            .commit()
    }

    private fun initProfile() {
        val call: Call<ResponseGitUserData> =
            GitServiceCreator.gitService.getUser("ze-zeh")
        call.enqueue(object : Callback<ResponseGitUserData> {
            override fun onResponse(
                call: Call<ResponseGitUserData>,
                response: Response<ResponseGitUserData>,
            ) {
                if (response.isSuccessful) {
                    val profile = response?.body() ?: ResponseGitUserData()
                    binding.user = User("조재훈", profile.name, "profile.introduction")
                    Glide.with(this@ProfileFragment)
                        .load(profile.image)
                        .circleCrop()
                        .into(binding.ivProfile)

                } else {
                    Toast.makeText(context, "profile load failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseGitUserData>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }

    private fun initBtn() {
        binding.btnFollowerList.setOnClickListener {
            transFragment(FOLLOWER_BTN)
        }

        binding.btnRepositoryList.setOnClickListener {
            transFragment(REPOSITORY_BTN)
        }
    }

    private fun transFragment(btn : Int) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()

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