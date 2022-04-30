package com.auto.brochure.repository

import com.auto.brochure.CarMake
import com.auto.brochure.MakeModel
import com.auto.brochure.ModelTrim
import com.auto.brochure.TrimDetails
import com.auto.brochure.repository.datasource.RetrofitApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CarInfoRepositoryImpl @Inject constructor(private val apiService: RetrofitApiService): CarInfoRepository {

    override fun getCarManufacturers(): Flow<List<CarMake>> = flow {
        apiService.getCarManufacturers().takeIf { it.isSuccessful }?.body()?.let {
            emit(it)
        }
    }

    override fun getModelsOfBrand(manufacturerCode: String): Flow<List<MakeModel>> {
        TODO("Not yet implemented")
    }

    override fun getModelTrims(modelCode: Int): Flow<List<ModelTrim>> {
        TODO("Not yet implemented")
    }

    override fun getTrimDetails(trimCode: String): Flow<TrimDetails> {
        TODO("Not yet implemented")
    }
}