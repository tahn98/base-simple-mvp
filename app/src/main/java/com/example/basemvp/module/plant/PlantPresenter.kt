package com.example.basemvp.module.plant

import com.example.basemvp.base.BasePresenter
import com.example.basemvp.module.plant.IPlantPresenter
import com.example.basemvp.module.plant.IPlantView
import com.example.basemvp.service.ApiRequestHelper
import com.example.basemvp.service.SunflowerApi

class PlantPresenter : IPlantPresenter, BasePresenter<IPlantView>(){
    override fun getAllPlant() {
        if(isViewAttacted()){
            ApiRequestHelper.asyncRequest(
                request = SunflowerApi.getInstance().getAllPlants(),
                onError = {errorMsg -> getView()?.onError(msg = errorMsg) },
                onSuccess = {response -> getView()?.onLoadPlantSuccess(response ?: listOf()) }
            )
        }
    }
}