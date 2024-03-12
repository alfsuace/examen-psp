package com.iesam.ex_22_23_psp_marzo.data.remote

import com.iesam.ex_22_23_psp_marzo.domain.Animal

class AdoptionRemoteDataSource {
    /**
     * Ejercicio 1.
     */

    private val apiAnimal = ApiAnimal()
    suspend fun getAdoptions(): List<Animal> {
        return apiAnimal.getAnimalList().map {
            it.toDomain()
        }
    }
}