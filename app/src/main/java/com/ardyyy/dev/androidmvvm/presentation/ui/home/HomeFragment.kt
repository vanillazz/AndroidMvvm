package com.ardyyy.dev.androidmvvm.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ardyyy.dev.androidmvvm.R
import com.ardyyy.dev.androidmvvm.data.local.entity.User
import com.ardyyy.dev.androidmvvm.presentation.detail.DetailActivity
import com.ardyyy.dev.androidmvvm.utils.NetworkHelper
import com.ardyyy.dev.androidmvvm.utils.UiState
import com.ardyyy.dev.androidmvvm.utils.showShortToast
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var listUser = ArrayList<User>()
    private lateinit var homeAdapter: HomeAdapter
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAdapter()
        initProcess()
    }

    private fun initAdapter() {
        homeAdapter = HomeAdapter(listUser) {
            println("clicked ${it.id}")
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRAS_USERS, it)
            startActivity(intent)
        }
        rvMain.adapter = homeAdapter
    }

    private fun initProcess() {
        homeViewModel.usersData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is UiState.Loading -> {
                    println("TESTT Loading")
                }
                is UiState.Success -> {
                    println("TESTT Success")
                    if (listUser.isNotEmpty()) listUser.clear()
                    it.data.data?.let { it1 -> listUser.addAll(it1) }
                    initAdapter()
                }
                is UiState.Error -> {
                    println("TESTT Error")
                    val message = NetworkHelper().getErrorMessage(it.throwable)
                    requireContext().showShortToast(message)
                }
            }
        })
        homeViewModel.getUsersData()
    }
}