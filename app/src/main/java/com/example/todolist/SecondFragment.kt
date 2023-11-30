package com.example.todolist

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentSecondBinding
import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar
import java.util.Date

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var sharedViewModel: TodoListViewModel

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {

            sharedViewModel.sharedVal =  sharedViewModel.sharedVal + 1

            var calendar = Calendar.getInstance()

            calendar.set(Calendar.YEAR, binding.tododate.year)
            calendar.set(Calendar.MONTH,binding.tododate.month)
            calendar.set(Calendar.DAY_OF_MONTH, binding.tododate.dayOfMonth)

            var date :LocalDate = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            var item = ListItem(sharedViewModel.sharedVal, binding.edittextSecond.text.toString(),date)
            sharedViewModel.addItem(item)

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity()).get(TodoListViewModel::class.java)
    }
}
