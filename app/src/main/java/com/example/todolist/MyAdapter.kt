package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val itemList: MutableList<ListItem>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoString: TextView = itemView.findViewById(R.id.todoString)
        val todoId: TextView = itemView.findViewById(R.id.todoId)
        val todoDelete : Button = itemView.findViewById(R.id.todoDelete)
        val todoDate : TextView = itemView.findViewById(R.id.todoDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todoitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.todoDelete.setOnClickListener(){
            itemList.removeAt(itemList.indexOf(item))
            notifyDataSetChanged()}
        holder.todoId.text = item.id.toString()
        holder.todoString.text = item.name
        holder.todoDate.text = item.date.toString()
    }

    override fun getItemCount(): Int = itemList.size
}

