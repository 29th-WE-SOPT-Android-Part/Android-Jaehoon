package org.sopt.androidseminar1.home.profile.follower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.androidseminar1.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private lateinit var binding : FragmentFollowerBinding
    private lateinit var followerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFollowerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = followerAdapter

        val uri1 = "https://www.riotgames.com/darkroom/2880/656220f9ab667529111a78aae0e6ab9f:d1a7c6d0384f2edf9672d9369a8e9083/01-logo.png"
        val uri2 = "https://oopy.lazyrockets.com/api/rest/cdn/image/ea394e8b-b63e-4a1f-93a7-9eacec8414af.png"
        val uri3 = "https://www.nicepng.com/png/detail/9-96158_riot-fist-inverted1-riot-games-fist-png.png"
        val uri4 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSP3ltW6s3tgglfG1R32s7Pw33JWvmBMFZUIx32obhGivs7omuXMNbtsJnWewV9UC-1-Ug&usqp=CAU"

        followerAdapter.followerList.addAll(
            listOf(
                Follower(uri1, "조재훈","안린이"),
                Follower(uri2, "이동기","안고수"),
                Follower(uri3, "문다빈","안팟장"),
                Follower(uri4, "김송현","운팀장")
            )
        )
    }
}