package com.yoesuv.mycoroutines.menu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoesuv.mycoroutines.R
import com.yoesuv.mycoroutines.databinding.ItemMainBinding
import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import com.yoesuv.mycoroutines.menu.viewmodels.ItemViewModel

class ListPlaceAdapter: ListAdapter<ListPlaceModel.PlaceModel, ListPlaceAdapter.PlaceViewHolder>(DiffCallback)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding: ItemMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_main, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bindData(getItem(holder.adapterPosition))
    }

    class PlaceViewHolder(private val itemMainBinding: ItemMainBinding) : RecyclerView.ViewHolder(itemMainBinding.root) {

        fun bindData(model: ListPlaceModel.PlaceModel) {
            val viewModel = ItemViewModel(model)
            itemMainBinding.item = viewModel
            itemMainBinding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<ListPlaceModel.PlaceModel>() {
        override fun areContentsTheSame(oldItem: ListPlaceModel.PlaceModel, newItem: ListPlaceModel.PlaceModel): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: ListPlaceModel.PlaceModel, newItem: ListPlaceModel.PlaceModel): Boolean {
            return oldItem.name == newItem.name
        }
    }
}