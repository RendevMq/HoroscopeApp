package com.rensystem.a04_androidintermedio.ui.horoscope

import androidx.lifecycle.ViewModel
import com.rensystem.a04_androidintermedio.data.providers.HoroscopeProvider
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo
import com.rensystem.a04_androidintermedio.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider) : ViewModel() {

    //val provider:HoroscopeProvider = HoroscopeProvider()...INCORRECTO
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList()) //Mutable
    val horoscope: StateFlow<List<HoroscopeInfo>> =  _horoscope //No es mutable, desde fuera no se podra modificar

    //Al crearese el ViewModel llama a este metodo
    init {
        //Coge el listado y lo actualiza
        _horoscope.value = horoscopeProvider.getHoroscope()
    }


}