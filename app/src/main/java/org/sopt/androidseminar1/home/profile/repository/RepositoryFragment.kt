package org.sopt.androidseminar1.home.profile.repository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidseminar1.databinding.FragmentRepositoryBinding

class RepositoryFragment : Fragment() {

    private lateinit var binding : FragmentRepositoryBinding
    private lateinit var repositoryAdapter: RepositoryAdpater

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        repositoryAdapter = RepositoryAdpater()
        binding.rvRepository.adapter = repositoryAdapter

        repositoryAdapter.repositoryList.addAll(
            listOf(
                Repository("안드로이드 과제 레포지토리", "안드로이드 파트 과제"),
                Repository("iOS 과제 레포지토리", "iOS 파트 과제"),
                Repository("서버 과제 레포지토리", "서버파트 과제"),
                Repository("웹 과제 레포지토리", "웹 파트 과제"),
            )
        )
    }
}