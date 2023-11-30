package com.example.todolist

import androidx.lifecycle.ViewModel

class TodoListViewModel : ViewModel() {

    val itemsList : MutableList<ListItem> = mutableListOf()

    var sharedVal : Int = 0

    fun addItem(item: ListItem){
        itemsList.add(item)
    }

    fun getItems():List<ListItem>{
        return itemsList
    }
}