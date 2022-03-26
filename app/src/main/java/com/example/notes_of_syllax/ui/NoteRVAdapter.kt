package com.example.notes_of_syllax.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes_of_syllax.databinding.NoteRvItemBinding
import com.example.notes_of_syllax.model.Note

class NoteRVAdapter(
    val context: Context,
    val noteClickDelete: NoteClickDelete,
    val noteClick: NoteClick,
) : RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NoteRvItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind.idTVNote.text = allNotes[position].noteTitle

        holder.bind.idIVDelete.setOnClickListener {
            noteClickDelete.onDeleteClick(allNotes[position])
        }

        holder.itemView.setOnClickListener {
            noteClick.onClick(allNotes[position])
        }
    }

    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = allNotes.size

    inner class ViewHolder(val bind: NoteRvItemBinding) : RecyclerView.ViewHolder(bind.root)


    interface NoteClickDelete {
        fun onDeleteClick(note: Note)
    }

    interface NoteClick {
        fun onClick(note: Note)
    }
}