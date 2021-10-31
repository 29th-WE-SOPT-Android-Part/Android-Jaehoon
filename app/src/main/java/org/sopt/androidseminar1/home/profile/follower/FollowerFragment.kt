package org.sopt.androidseminar1.home.profile.follower

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        followerAdapter.followerList.addAll(
            listOf(
                Follower("조재훈","안린이"),
                Follower("이동기","안고수"),
                Follower("문다빈","안팟장"),
                Follower("김송현","운팀장")
            )
        )
    }
}