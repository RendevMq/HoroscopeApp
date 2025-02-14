package com.rensystem.a04_androidintermedio.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rensystem.a04_androidintermedio.databinding.ItemHoroscopeBinding
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo

class HoroscopeViewHolder (view : View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun bind(horoscopeInfo : HoroscopeInfo){
        val context = binding.tvTitleHoroscope.context //todos tienen su contexto
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitleHoroscope.text = context.getString(horoscopeInfo.name)
    }
}