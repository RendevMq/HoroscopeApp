package com.rensystem.a04_androidintermedio.data

import android.util.Log
import com.rensystem.a04_androidintermedio.data.network.HoroscopeApiService
import com.rensystem.a04_androidintermedio.data.network.response.PredictionResponse
import com.rensystem.a04_androidintermedio.domain.Repository
import com.rensystem.a04_androidintermedio.domain.model.PredictionModel
import javax.inject.Inject

//Desde la Imlementacion del Repository inyectamos el apiservice
class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediccion(sign: String): PredictionModel? {
        //Peticion Retrofit
        kotlin.runCatching {
            apiService.getHoroscope(sign)
        }.onSuccess {
            return it.toDomain()
        }.onFailure {
            Log.i("Renato", "Ocurrio un error ${it.message}")
        }

        return null
    }
}