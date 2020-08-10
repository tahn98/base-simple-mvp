package com.example.basemvp.module.plant

import com.example.basemvp.model.Plant

interface IPlantView {
    fun onLoadPlantSuccess(plants: List<Plant>)
    fun onError(msg: String)
    fun showError(msg: String)
    fun showProgress()
    fun hideProgress()
}