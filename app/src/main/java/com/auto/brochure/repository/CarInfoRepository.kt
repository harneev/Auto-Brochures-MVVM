package com.auto.brochure.repository

import com.auto.brochure.CarMake
import com.auto.brochure.MakeModel
import com.auto.brochure.ModelTrim
import com.auto.brochure.TrimDetails
import kotlinx.coroutines.flow.Flow

interface CarInfoRepository {

    fun getCarManufacturers(): Flow<List<CarMake>>

    fun getModelsOfBrand(manufacturerCode: String): Flow<List<MakeModel>>

    fun getModelTrims(modelCode: Int): Flow<List<ModelTrim>>

    fun getTrimDetails(trimCode: String): Flow<TrimDetails>
}