package com.example.todolist

import java.time.LocalDate
import java.util.Date

data class ListItem(
    val id: Int,
    val name: String,
    val date: LocalDate
)
