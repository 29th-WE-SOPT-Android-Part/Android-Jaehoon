package org.sopt.androidseminar1.home.profile.follower

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.sopt.androidseminar1.*
import org.sopt.androidseminar1.databinding.FragmentFollowerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerFragment : Fragment() {
    private lateinit var binding: FragmentFollowerBinding
    private lateinit var followerAdapter: FollowerAdapter
    private lateinit var gitFollowerList: List<ResponseGitUserData>
    private var list = mutableListOf<Follower>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFollowerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initFollowerList()
    }


    private fun initFollowerList() {
        val call: Call<List<ResponseGitUserData>> =
            GitServiceCreator.gitService.getGitFollowers("ze-zeh")
        call.enqueue(object : Callback<List<ResponseGitUserData>> {
            override fun onResponse(
                call: Call<List<ResponseGitUserData>>,
                response: Response<List<ResponseGitUserData>>,
            ) {
                if (response.isSuccessful) {
                    gitFollowerList = response?.body() ?: listOf()

                    for (follower in gitFollowerList) {
                        list.add(Follower(follower.image, follower.name, "follower.introduction"))
                    }
                    initAdapter()

                } else {
                    Toast.makeText(context, "follower list load failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseGitUserData>>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }

    private fun initAdapter() {
        Log.d("testtt", "f_size: ${list.size.toString()}")
        followerAdapter = FollowerAdapter(list)
        binding.rvFollower.adapter = followerAdapter
    }
}