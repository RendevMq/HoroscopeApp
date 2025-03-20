package com.rensystem.a04_androidintermedio.ui.horoscope

import com.rensystem.a04_androidintermedio.data.providers.HoroscopeProvider
import com.rensystem.a04_androidintermedio.modelobject.HoroscopeMotherObject
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class HoroscopeViewModelTest {

    //    @MockK(relaxed = true)
    @MockK()
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }


    //testeamos que siempre que cargue la pantalla cargue el listado
    @Test
    fun `when viewmodel is created then horoscope are loaded`() {
        //GIVEN
        every { horoscopeProvider.getHoroscope() } returns HoroscopeMotherObject.horoscopeInfoList
        // Aquí estoy configurando el mock del proveedor de horóscopos para que devuelva una lista de horóscopos predefinida
        // (HoroscopeMotherObject.horoscopeInfoList). Esto es necesario porque el 'horoscopeProvider' está siendo simulado (mockeado),
        // lo cual significa que no se hará una llamada real al proveedor. Cuando el mettodo 'getHoroscope()' se invoque,
        // se devolverá esta respuesta mockeada, lo que nos permite controlar el valor que recibe el ViewModel para testear su comportamiento.
        // Si la función 'getHoroscope()' estuviera usando corutinas, sería necesario usar 'coevery' para simular respuestas asincrónicas.

        viewModel = HoroscopeViewModel(horoscopeProvider) // inicializo

        //WHEN
        val horoscope = viewModel.horoscope.value

        assertTrue(horoscope.isNotEmpty())

    }
}