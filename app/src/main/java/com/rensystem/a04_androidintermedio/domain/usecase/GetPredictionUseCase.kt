package com.rensystem.a04_androidintermedio.domain.usecase

import com.rensystem.a04_androidintermedio.domain.Repository
import javax.inject.Inject

// Se inyecta el Repository porque la capa Domain no debe depender directamente de la capa Data.
// Si no se inyectara, la capa Domain tendría que conocer los detalles de implementación de Repository,
// incluyendo que este depende de un ApiService, lo cual rompería el principio de separación de responsabilidades.
// Al inyectarlo, garantizamos que Domain solo trabaja con abstracciones y no con detalles de Data.

class GetPredictionUseCase @Inject constructor(private val repository : Repository) {

    suspend operator fun invoke(sign:String) =
        repository.getPrediccion(sign)

}