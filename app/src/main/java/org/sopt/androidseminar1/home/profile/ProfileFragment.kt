package org.sopt.androidseminar1.home.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import org.sopt.androidseminar1.R
import org.sopt.androidseminar1.User
import org.sopt.androidseminar1.databinding.FragmentProfileBinding
import org.sopt.androidseminar1.home.profile.follower.FollowerFragment
import org.sopt.androidseminar1.home.profile.repository.RepositoryFragment

class ProfileFragment : Fragment() {
    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        init()
        initBtn()

        return binding.root
    }

    private fun init() {
        val followerFragment = FollowerFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(R.id.fc_home_list, followerFragment)
            .commit()

        Glide.with(this)
            .load("https://www.riotgames.com/darkroom/2880/656220f9ab667529111a78aae0e6ab9f:d1a7c6d0384f2edf9672d9369a8e9083/01-logo.png")
            .circleCrop()
            .into(binding.ivProfile)

        binding.user = User("조재훈", "jaehoon_jo", "안드파트 최고!")
    }

    private fun initBtn() {
//        binding.btnGit.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jaehoon-jo"))
//            startActivity(intent)
//        }

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