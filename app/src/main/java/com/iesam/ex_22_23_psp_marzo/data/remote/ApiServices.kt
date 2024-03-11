package com.iesam.ex_22_23_psp_marzo.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("adoptions.json")
    fun listAnimal(): Response<List<AnimalRemoteModel>>

    @GET("adoptions.json")
    fun listAnimalType(): Response<List<AnimalTypeRemoteModel>>

}