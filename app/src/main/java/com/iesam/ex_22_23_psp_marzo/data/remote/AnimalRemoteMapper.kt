package com.iesam.ex_22_23_psp_marzo.data.remote

import com.iesam.ex_22_23_psp_marzo.domain.Animal
import com.iesam.ex_22_23_psp_marzo.domain.AnimalType

fun AnimalTypeRemoteModel.toDomain(): AnimalType {
    return AnimalType(
        this.id,
        this.name
    )
}

fun AnimalRemoteModel.toDomain(): Animal {
    return Animal(
        this.id,
        this.name,
        this.description,
        this.breed,
        this.sex,
        this.dateBorn,
        this.size,
        this.urlImage,
        type.toDomain(),
        this.gallery,
        this.shorDescription,
        this.urlSource
    )
}