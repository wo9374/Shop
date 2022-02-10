package com.example.shop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.databinding.ItemTestBinding
import com.example.shop.model.Test

class TestAdapter : RecyclerView.Adapter<TestViewHolder>() {
    private var test = emptyList<Test>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val binding: ItemTestBinding = ItemTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val ex = test[position]
        holder.bind(ex)
    }

    override fun getItemCount(): Int {
        return test.size
    }

    internal fun setTest(test:List<Test>){
        this.test = test
        notifyDataSetChanged()
    }
}

class TestViewHolder(val binding: ItemTestBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(test: Test) {
        binding.test = test

        /*binding.root.setOnClickListener {

        }
        binding.root.setOnLongClickListener {
            true
        }*/
    }
}