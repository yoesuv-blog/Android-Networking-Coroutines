package com.yoesuv.mycoroutines.menu.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.yoesuv.mycoroutines.R
import com.yoesuv.mycoroutines.databinding.ActivityMainBinding
import com.yoesuv.mycoroutines.menu.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel(application)
        binding.main = viewModel

        viewModel.getListPlace()
    }
}
