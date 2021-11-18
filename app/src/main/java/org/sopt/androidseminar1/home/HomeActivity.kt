package org.sopt.androidseminar1.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import org.sopt.androidseminar1.R
import org.sopt.androidseminar1.databinding.ActivityHomeBinding
import org.sopt.androidseminar1.home.camera.CameraFragment
import org.sopt.androidseminar1.home.home.HomeFragment
import org.sopt.androidseminar1.home.profile.ProfileFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var homeActivityViewPagerAdapter : HomeActivityViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        initAdapter()
        initBottomNavigation()
    }

    private fun initAdapter() { // ViewPage2 연동
        val fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())
        homeActivityViewPagerAdapter = HomeActivityViewPagerAdapter(this)
        homeActivityViewPagerAdapter.fragments.addAll(fragmentList)
        binding.vpHome.adapter = homeActivityViewPagerAdapter
    }

    private fun initBottomNavigation() { // BottomNavigationView과 ViewPager2 연동
        // ViewPage2가 바뀌었을 때 BottomNavigationView의 대응하는 메뉴로 바꿈
        binding.vpHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bnvHome.menu.getItem(position).isChecked = true
            }
        })

        // BottomNavigationView가 바뀌었을 때 ViewPage2의 대응하는 Fragment로 바꿈
        binding.bnvHome.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_profile -> {
                    binding.vpHome.currentItem = FIRST_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_home -> {
                    binding.vpHome.currentItem = SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vpHome.currentItem = THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object {
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }
}