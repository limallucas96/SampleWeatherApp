package com.example.sampleweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel by inject<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.weatherLiveData.observe(this, {

            tvName.text = it.name.orEmpty()
            tvFeelsLike.text = (it.main?.feelsLike ?: 0.0).toString()
            tvMax.text = (it.main?.tempMax ?: 0.0).toString()
            tvMin.text = (it.main?.tempMin ?: 0.0).toString()
            tvCoord.text = String.format("%s, %s", (it.coord?.lat ?: 0.0).toString(), (it.coord?.lon ?: 0.0).toString())

        })

        viewModel.getWeatherDetail("Rio de janeiro")
    }

}