package com.rensystem.a04_androidintermedio.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rensystem.a04_androidintermedio.R
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo
import com.rensystem.a04_androidintermedio.ui.horoscope.HoroscopeViewModel

class HoroscopeAdapter (private var horoscopeList : List<HoroscopeInfo> = emptyList()) : RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(horoscopeList : List<HoroscopeInfo>) {
        this.horoscopeList = horoscopeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope,parent,false)
        return HoroscopeViewHolder(layout)
    }


    override fun onBindViewHolder(viewHolder: HoroscopeViewHolder, position: Int) {
        val item = horoscopeList[position]
        return viewHolder.bind(item)
    }

    override fun getItemCount() = horoscopeList.size
}