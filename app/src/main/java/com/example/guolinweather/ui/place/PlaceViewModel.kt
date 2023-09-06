package com.example.guolinweather.ui.place

import androidx.lifecycle.*
import com.example.guolinweather.logic.Repository
import com.example.guolinweather.logic.model.Place

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }


    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
}