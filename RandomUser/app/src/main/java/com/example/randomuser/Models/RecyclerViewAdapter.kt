package com.example.randomuser.Models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.randomuser.R
import com.example.randomuser.RandomAPI.Result
import com.example.randomuser.databinding.StaggeredItemviewBinding

class RecyclerViewAdapter(private var itemList: ArrayList<Result>,private var width: Int) : ListAdapter<Result,RecyclerViewAdapter.ItemViewHolder>(DiffUtil())
{
    inner class ItemViewHolder(val binding: StaggeredItemviewBinding):RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val email = binding.email

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                val clickedItem = itemList[position]

                val bundle = bundleOf(
                    "imageUrl" to clickedItem.picture.large,
                    "name" to "${clickedItem.name.first} ${clickedItem.name.last}",
                    "email" to clickedItem.email,
                    "country" to clickedItem.location.country,
                    "phone" to clickedItem.phone,
                    "dob" to clickedItem.dob.date
                )
                it.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
            }
        }
    }

    fun setFilteredList(list: ArrayList<Result>) {
        itemList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            StaggeredItemviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val imageUrl = itemList[position].picture.large
        val name = itemList[position].name.first + itemList[position].name.last
        val email = itemList[position].email

        holder.binding.apply {
            val imageView = profile

            if (position % 2 == 0) {
                imageView.layoutParams.width = width * 3 / 4 - 20
                imageView.requestLayout()
                imageView.load(imageUrl)
            }
            else {
                imageView.layoutParams.width = width * 1 / 4 - 20
                imageView.requestLayout()
                imageView.load(imageUrl)
            }
        }
        holder.email.text = email
        holder.name.text = name
    }
}

class DiffUtil : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
}