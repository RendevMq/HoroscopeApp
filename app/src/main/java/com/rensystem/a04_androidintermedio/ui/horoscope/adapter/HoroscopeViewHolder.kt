package com.rensystem.a04_androidintermedio.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.rensystem.a04_androidintermedio.databinding.ItemHoroscopeBinding
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun bind(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvTitleHoroscope.context //todos tienen su contexto
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitleHoroscope.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(
                binding.ivHoroscope,
                newLambda = { onItemSelected(horoscopeInfo) }
            )
            //onItemSelected(horoscopeInfo) //se ejcuta al dar click en el parent
        }
    }

    private fun startRotationAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 300
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { //Se ejecuta el terminar la accion
                newLambda()
            }
            start()
        }
    }
}