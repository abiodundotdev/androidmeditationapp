package com.example.meditationapp.data.repository

import com.example.meditationapp.data.services.StoreService
import com.example.meditationapp.domain.models.ProductModel
import com.example.meditationapp.domain.responses.BaseApiResponse
import com.example.meditationapp.domain.responses.GetProductsResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class StoreRepository @Inject constructor(
    private val storeService: StoreService
) : BaseApiResponse() {
    suspend fun getProducts(): Flow<GetProductsResponse<List<ProductModel>>> {
        return flow<GetProductsResponse<List<ProductModel>>> {
            emit(safeApiCall{ storeService.getProducts()})
        }.flowOn(Dispatchers.IO)
    }
}