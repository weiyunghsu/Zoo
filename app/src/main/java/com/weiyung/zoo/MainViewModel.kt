package com.weiyung.zoo

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    private val _contentLiveData = MutableLiveData<List<HouseResult>>()
    val contentLiveData: LiveData<List<HouseResult>>
        get() = _contentLiveData

//    init {
//        getContentLiveData()
//    }
    val currentFragmentType = MutableLiveData<CurrentFragmentType>()
    val currentDrawerToggleType: LiveData<DrawerToggleType> = Transformations.map(currentFragmentType) {
        when (it) {
            CurrentFragmentType.HOUSE -> DrawerToggleType.BACK
            CurrentFragmentType.SPECIES -> DrawerToggleType.BACK
            else -> DrawerToggleType.NORMAL
        }
    }
//    private fun getContentLiveData() {
//        Log.i("MainViewModel", "getContentLiveData")
//        viewModelScope.launch {
//            try {
//                _contentLiveData.value = ZooApi.retrofitService.getMarketingHots().data
//                Log.i("MainViewModel", ZooApi.retrofitService.getMarketingHots().toString())
//            } catch (e: Exception) {
//                Log.i("MainViewModel", e.toString())
//            }
//        }
//    }
}