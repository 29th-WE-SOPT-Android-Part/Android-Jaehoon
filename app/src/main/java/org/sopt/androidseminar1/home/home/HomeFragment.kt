package org.sopt.androidseminar1.home.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.androidseminar1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeFragmentTabViewPagerAdapter: HomeFragmentTabViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initAdapter()
        initTablayout()

        return binding.root
    }

    private fun initAdapter() { // ViewPage2와 Adapter 연동
        val fragmentList = listOf(HomeFollowingFragment(), HomeFollowerFragment())

        homeFragmentTabViewPagerAdapter = HomeFragmentTabViewPagerAdapter(this)
        homeFragmentTabViewPagerAdapter.fragments.addAll(fragmentList)
        binding.vpHomeFragment.adapter = homeFragmentTabViewPagerAdapter
    }

    private fun initTablayout() {
        val tabLabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.tlHomeFragment, binding.vpHomeFragment) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }
}