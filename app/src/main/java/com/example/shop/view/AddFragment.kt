package com.example.shop.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.shop.R
import com.example.shop.databinding.FragmentAddBinding
import com.example.shop.databinding.FragmentHomeBinding
import com.example.shop.model.Test
import com.example.shop.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class AddFragment : Fragment() {
    lateinit var binding : FragmentAddBinding
    lateinit var navController : NavController

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add,container,false)

        activity?.let {
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(binding.root)

        binding.addButton.setOnClickListener {
            if (binding.addEdittextTitle.text.isNotEmpty() && binding.addEdittextDescript.text.isNotEmpty()){
                val id = viewModel.getAll().value?.size ?: 0
                val test = Test(id+1,
                    binding.addEdittextTitle.text.toString(),
                    binding.addEdittextDescript.text.toString(),
                    "")
                //lifecycleScope.launch(Dispatcher)
            }
        }
    }
}