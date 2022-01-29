package win.ca.demo.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import win.ca.demo.myapplication.R
import win.ca.demo.myapplication.data.api.model.Note
import win.ca.demo.myapplication.databinding.ViewNoteItemBinding

class MainRecyclerAdapter : ListAdapter<Note, MainRecyclerAdapter.MainVh>(DiffCallback()) {

    inner class MainVh(val binding: ViewNoteItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            binding.note = note
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVh {
        val itemLayoutBinding = DataBindingUtil.inflate<ViewNoteItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.view_note_item,
            parent,
            false
        )
        return MainVh(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: MainVh, position: Int) {
        val note = getItem(position)
        holder.bind(note)
    }

    class DiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id && oldItem.author == newItem.author
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    fun setData(data : List<Note>){
        submitList(null)
        submitList(data)
    }
}