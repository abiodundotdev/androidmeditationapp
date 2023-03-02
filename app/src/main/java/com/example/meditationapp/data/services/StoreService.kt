package com.example.meditationapp.data.services

import com.example.meditationapp.core.constants.EndPoints
import com.example.meditationapp.domain.models.ProductModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreService {
        @GET(EndPoints.Products)
        suspend fun getProducts(): Response<List<ProductModel>>

        @GET(EndPoints.Products+"/{id}")
        suspend fun getProduct(@Path("id") groupId: Int): Response<ProductModel>

        @GET(EndPoints.Categories)
        suspend fun getCategories(): Response<List<String>>

        @GET(EndPoints.Carts)
        suspend fun getCarts(): Response<List<String>>

}