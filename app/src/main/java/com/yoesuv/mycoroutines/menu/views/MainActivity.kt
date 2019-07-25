package com.yoesuv.mycoroutines.menu.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoesuv.mycoroutines.R
import com.yoesuv.mycoroutines.databinding.ActivityMainBinding
import com.yoesuv.mycoroutines.menu.adapters.ListPlaceAdapter
import com.yoesuv.mycoroutines.menu.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var listPlaceAdapter: ListPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel(application)
        binding.main = viewModel

        setupRecyclerView()
        setupSwipeRefresh()

        observeLiveData()
        viewModel.getListPlace()
    }

    private fun observeLiveData() {
        viewModel.liveDataListPlace.observe(this, Observer {
            listPlaceAdapter.submitList(it)
        })
        viewModel.isLoading.observe(this, Observer {
            binding.swipeRefreshLayout.isRefreshing = it
        })
    }

    private fun setupRecyclerView() {
        listPlaceAdapter = ListPlaceAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = listPlaceAdapter
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getListPlace()
        }
    }
}
