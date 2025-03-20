package com.rensystem.a04_androidintermedio.modelobject

import com.rensystem.a04_androidintermedio.data.network.response.PredictionResponse
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Aquarius
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Aries
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Cancer
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Capricorn
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Gemini
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Leo
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Libra
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Pisces
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Sagittarius
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Scorpio
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Taurus
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.Virgo

object HoroscopeMotherObject {

    val anyResponse = PredictionResponse("date", "prediccion", "taurus")

    val horoscopeInfoList = listOf(
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