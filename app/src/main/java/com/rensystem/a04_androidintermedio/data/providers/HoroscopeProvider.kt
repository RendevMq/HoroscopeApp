package com.rensystem.a04_androidintermedio.data.providers

import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.*
import javax.inject.Inject


//@Inject constructor(): Se prepara la clase para que se pueda inyectar
class HoroscopeProvider @Inject constructor(){
    fun getHoroscope(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}