package com.example.shop.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.shop.R
import com.example.shop.adapter.TestAdapter
import com.example.shop.databinding.FragmentMessageBinding
import com.example.shop.viewmodel.MainViewModel

class MessageFragment : Fragment() {
    lateinit var binding: FragmentMessageBinding
    lateinit var navController: NavController

    //activity 의 ViewModel 을 따름
    private val viewModel: MainViewModel by activityViewModels()

    var floatingFlag = false
    lateinit var fabOpen : Animation
    lateinit var fabClose : Animation

    lateinit var msgLayoutManager : LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false)

        activity?.let {
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(binding.root)

        initComponent()

        setRecyclerInit()

        binding.callBack = callBack
    }

    private fun setRecyclerInit() {
        val testAdapter = TestAdapter()

        viewModel.getAll().observe(viewLifecycleOwner, Observer { test ->
            test?.let { testAdapter.setTest(test) }
        })

        //notifyDataSet 깜빡임 방지
        val animator = binding.recyclerMessage.itemAnimator
        if (animator is SimpleItemAnimator){
            animator.supportsChangeAnimations = false
        }

        binding.recyclerMessage.apply {
            adapter = testAdapter
            layoutManager = msgLayoutManager
            itemAnimator = animator
            setHasFixedSize(true)
            //item 이 추가되거나 삭제될 때 RecyclerView 의 크기가 변경될 수도 있고, 그렇게 되면 계층 구조의 다른 View 크기가 변경될 가능성이 있기 때문
        }
    }

    private fun initComponent() {
        fabOpen = AnimationUtils.loadAnimation(context, R.anim.fab_open)
        fabClose = AnimationUtils.loadAnimation(context, R.anim.fab_close)

        msgLayoutManager = LinearLayoutManager(context)
    }

    interface CallBack {
        fun onClick(view: View)
    }
    private val callBack = object : CallBack {
        override fun onClick(view: View) {
            when (view.id) {
                binding.fabMain.id,
                binding.fab1.id,
                binding.fab2.id,
                binding.fab3.id-> {
                    binding.apply {
                        if (!floatingFlag){
                            fabLayout1.startAnimation(fabOpen)
                            fabLayout2.startAnimation(fabOpen)
                            fabLayout3.startAnimation(fabOpen)
                        }else{
                            fabLayout1.startAnimation(fabClose)
                            fabLayout2.startAnimation(fabClose)
                            fabLayout3.startAnimation(fabClose)
                        }
                    }
                    floatingFlag = floatingFlag.not()

                    navController.navigate(R.id.action_messageFragment_to_addFragment)
                }
            }
        }
    }

}