package com.iesam.ex_22_23_psp_marzo.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiAnimal {
    private val urlEndPoint = "https://huellas.sitehub.es/api/v1/"
    private var apiEndPoint: ApiServices

    init {
        apiEndPoint = buildApiEndPoint()
    }

    private fun buildApiEndPoint(): ApiServices {
        return buildClient().create(ApiServices::class.java)
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    suspend fun getAnimalList(): List<AnimalRemoteModel> {
        val response = apiEndPoint.listAnimal()
            return response.body()!!
    }
    suspend fun getAnimalType(): AnimalTypeRemoteModel{
        val response = apiEndPoint.listAnimalType()
            return response.body()!!
    }
}