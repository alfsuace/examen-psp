package com.iesam.ex_22_23_psp_marzo.domain

class GetAdoptionsUseCase(private val adoptions: AdoptionRepository) {

    suspend operator fun invoke(): List<Animal> {
        return adoptions.getAdoptions()
    }
}