package com.weiyung.zoo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weiyung.zoo.databinding.ContentSpeciesBinding

class HouseAdapter (private val onClickListener: OnClickListener):
    ListAdapter<Animal, HouseAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ContentSpeciesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(animal)
        }
        holder.bind(animal)
    }

    class ViewHolder(private val binding: ContentSpeciesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animal) {
            binding.animal = animal
            binding.executePendingBindings()
        }

    }
    object DiffCallback : DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem._id == newItem._id
        }
    }
    class OnClickListener(val clickListener: (animal:Animal) -> Unit){
        fun onClick(animal:Animal) = clickListener(animal)
    }

}