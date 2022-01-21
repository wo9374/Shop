package com.example.shop.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.shop.R
import com.example.shop.databinding.FragmentFavoriteBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate

class FavoriteFragment : Fragment() {
    lateinit var binding : FragmentFavoriteBinding
    lateinit var navController : NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_favorite,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(binding.root)

        //퍼센트로 계산
        binding.chart.setUsePercentValues(true)

        //data Set
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(508f, "Apple"))
        entries.add(PieEntry(600f, "Orange"))
        entries.add(PieEntry(750f, "Mango"))
        entries.add(PieEntry(508f, "RedOrange"))
        entries.add(PieEntry(670f, "Other"))

        //add a lot of colors
        val colorsItems = ArrayList<Int>()
        for (c in ColorTemplate.VORDIPLOM_COLORS) colorsItems.add(c)
        for (c in ColorTemplate.JOYFUL_COLORS) colorsItems.add(c)
        for (c in ColorTemplate.COLORFUL_COLORS) colorsItems.add(c)
        for (c in ColorTemplate.LIBERTY_COLORS) colorsItems.add(c)
        for (c in ColorTemplate.PASTEL_COLORS) colorsItems.add(c)
        colorsItems.add(ColorTemplate.getHoloBlue())
        //해당 그래프의 아이템별 범위의 색을 set 해주는데 일단 List 값에 담아서 셋팅

        val pieDataSet = PieDataSet(entries, "")
        pieDataSet.apply {
            colors = colorsItems
            valueTextColor = Color.BLACK
            valueTextSize = 16f
        }
        //PieDataSet 변수를 만들어 위에서 셋팅한 색상과 그래프에 들어갈 퍼센티이지 수치 색상과 사이즈 지정 가능

        val pieData = PieData(pieDataSet)
        binding.chart.apply {
            data = pieData
            description.isEnabled = true   //설명
            description.text = "파이그래프"
            isRotationEnabled = true       //드래그시 회전
            centerText = "파이그래프 Center"   //중앙 text
            setEntryLabelColor(Color.BLACK)
            animateY(1500, Easing.EaseInOutQuad)
            animate()

            setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
                override fun onValueSelected(e: Entry?, h: Highlight?) {
                    Log.d("HomeFragment", "${e?.data}")
                }
                override fun onNothingSelected() {}
            })
        }
    }
}