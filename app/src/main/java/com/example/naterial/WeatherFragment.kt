package com.example.naterial

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.api.load
import kotlinx.android.synthetic.main.fragment_mars.*

class WeatherFragment : Fragment(R.layout.fragment_weather) {


    private val viewModel: PictureOfSame2DayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfSame2DayViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getData()
                .observe(viewLifecycleOwner, { renderData(it) })
    }

    private fun renderData(data: PictureOfTheDayData) {
        when (data) {
            is PictureOfTheDayData.Success -> {
                val serverResponseData = data.serverResponseData
                val url = serverResponseData.url
                if (url.isNullOrEmpty()) {
                    toast("Link is empty")
                } else {
                    image_view.load(url) {
                        crossfade(true)
                        lifecycle(this@WeatherFragment)
                        error(R.drawable.ic_load_error_vector)
                        placeholder(R.drawable.ic_no_photo_vector)
                    }
                    description.text = serverResponseData.explanation
                }
            }
            is PictureOfTheDayData.Loading -> {
            }
            is PictureOfTheDayData.Error -> {
                toast(data.error.message)
            }
        }
    }

    private fun Fragment.toast(string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 250)
            show()
        }
    }


}