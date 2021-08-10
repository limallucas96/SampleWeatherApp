package com.example.sampleweatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.sampleweatherapp.data.entities.WeatherEntity
import com.example.sampleweatherapp.repository.MainRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MainActivityViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    val dispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var mainRepository: MainRepository

    lateinit var mainViewModel: MainActivityViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        mainViewModel = MainActivityViewModel(mainRepository)
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testTemp() {
        coEvery { mainRepository.getWeatherDetail("") } returns Response.success(WeatherEntity(name = "teste"))

        mainViewModel.weatherLiveData.observeForever { }
        mainViewModel.getWeatherDetail("")

        assert(mainViewModel.weatherLiveData.value?.name == "teste")

    }

}