package com.weiyung.zoo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    val currentFragmentType = MutableLiveData<CurrentFragmentType>()
    val currentDrawerToggleType: LiveData<DrawerToggleType> = Transformations.map(currentFragmentType) {
        when (it) {
            CurrentFragmentType.HOUSE -> DrawerToggleType.BACK
            CurrentFragmentType.SPECIES -> DrawerToggleType.BACK
            else -> DrawerToggleType.NORMAL
        }
    }
}