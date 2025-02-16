package com.rensystem.a04_androidintermedio.domain

import com.rensystem.a04_androidintermedio.data.network.response.PredictionResponse
import com.rensystem.a04_androidintermedio.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediccion(sign: String): PredictionModel?
}