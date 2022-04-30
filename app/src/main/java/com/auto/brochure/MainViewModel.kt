package com.auto.brochure

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.auto.brochure.repository.CarInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: CarInfoRepository) : ViewModel() {

    fun getCarManufacturerList() : LiveData<List<CarMake>> = repository.getCarManufacturers().asLiveData()

    fun getModelsList(manufacturerCode: String): LiveData<List<MakeModel>> =
        repository.getModelsOfBrand(manufacturerCode).asLiveData()

}