package org.d3if4035.assessment2.data

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TokoViewModel(private val tokoDao: TokoDao): ViewModel() {

    val data = tokoDao.getDataToko()

    fun addToko(tokoEntity: TokoEntity){
        viewModelScope.launch{
            tokoDao.insert(tokoEntity)
        }
    }

    fun deleteToko(tokoEntity: TokoEntity){
        viewModelScope.launch ( Dispatchers.IO ){
            tokoDao.delete(tokoEntity)
        }
    }


}

class TokoViewModelFactory(private val tokoDao: TokoDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TokoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TokoViewModel(tokoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}