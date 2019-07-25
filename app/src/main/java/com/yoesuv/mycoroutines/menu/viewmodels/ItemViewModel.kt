package com.yoesuv.mycoroutines.menu.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.yoesuv.mycoroutines.menu.models.ListPlaceModel

class ItemViewModel(model: ListPlaceModel.PlaceModel) : ViewModel() {

    var name: ObservableField<String> = ObservableField(model.name)
    var location: ObservableField<String> = ObservableField(model.location)
    var imageUrl: ObservableField<String> = ObservableField(model.image)

}