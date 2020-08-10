package com.example.basemvp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.basemvp.R
import com.example.basemvp.model.Plant
import com.example.basemvp.module.plant.IPlantView
import com.example.basemvp.module.plant.PlantPresenter

class PlantFragment : Fragment(), IPlantView {

    private lateinit var plantPresenter: PlantPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        init()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_plant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plantPresenter.attachView(this)
        plantPresenter.getAllPlant()
    }

    override fun onDestroy() {
        super.onDestroy()
        plantPresenter.detachView()
    }

    private fun init(){
        plantPresenter = PlantPresenter()
    }

    override fun onLoadPlantSuccess(plants: List<Plant>) {
        Log.d("response", plants.toString())
    }

    override fun onError(msg: String) {
        Log.d("error", msg)
    }

    override fun showError(msg: String) {
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }
}