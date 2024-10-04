package com.example.base

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.base.databinding.RecBinding

class MonAdapter : ListAdapter<MainActivity.album, MonAdapter.MonItemview>(MonItemDiffCallback) {
    inner class MonItemview(private val binding: RecBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(album :MainActivity.album){
            binding.id.text = MainActivity.album.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonItemview {
        val binding:RecBinding = RecBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonItemview(binding)
    }

    override fun onBindViewHolder(holder: MonItemview, position: Int) {
        val item : String = getItem(position)
        holder.bind(item)

        val DepxADp = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 150f, holder.itemView.context.resources.displayMetrics
        ).toInt()

        val params = holder.itemView.layoutParams
        params.height = DepxADp
        holder.itemView.layoutParams
    }
}

object MonItemDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}