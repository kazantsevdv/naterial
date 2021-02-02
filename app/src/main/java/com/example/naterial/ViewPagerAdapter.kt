package com.example.naterial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

private const val POD_FRAGMENT = 0
private const val FRAGMENT_RECYCLER = 1
private const val FRAGMENT_3 = 2
private const val FRAGMENT_CALC = 3

class ViewPagerAdapter(private val fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = arrayOf(PictureOfTheDayFragment(), Fragment_Recycler(), Fragment_3(), Fragment_calc())

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> fragments[POD_FRAGMENT]
            1 -> fragments[FRAGMENT_RECYCLER]
            2 -> fragments[FRAGMENT_3]
            3 -> fragments[FRAGMENT_CALC]
            else -> fragments[POD_FRAGMENT]
        }
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "POD"
            1 -> "Recycler"
            2 -> "Вкл"
            3 -> "Калк"
            else -> "Вкладка 1"
        }
    }

}
