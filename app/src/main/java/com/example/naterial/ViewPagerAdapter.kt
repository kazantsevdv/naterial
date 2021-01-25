package com.example.naterial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

private const val POD_FRAGMENT = 0
private const val MARS_FRAGMENT = 1
private const val WEATHER_FRAGMENT = 2

class ViewPagerAdapter(private val fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = arrayOf(PictureOfTheDayFragment(), MarsFragment(), WeatherFragment())

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> fragments[POD_FRAGMENT]
            1 -> fragments[MARS_FRAGMENT]
            2 -> fragments[WEATHER_FRAGMENT]
            else -> fragments[POD_FRAGMENT]
        }
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Фкладка 1"
            1 -> "Фкладка 2"
            2 -> "Фкладка 3"
            else -> "Фкладка 1"
        }
    }

}
