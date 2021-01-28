package com.example.naterial

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.main_fragment_start.*


class MainFragment : Fragment(R.layout.main_fragment_start) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_pager.adapter = ViewPagerAdapter(childFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
        setBottomAppBar(view)
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position
                SwitchTo(tab);
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }


    private fun SwitchTo(tab: TabLayout.Tab?) {
        val view = tab!!.view

        ObjectAnimator.ofFloat(view, "scaleX", 0.5f, 1.5f, 0.8f, 1.2f, 1.1f).setDuration(1000).start()
        ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1.5f, 1.1f).setDuration(500).start()
        ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).setDuration(1000).start()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.app_bar_settings -> activity?.supportFragmentManager?.beginTransaction()?.add(R.id.container, SettingsFragment())?.addToBackStack(null)?.commit()

        }
        return super.onOptionsItemSelected(item)
    }


    private fun setBottomAppBar(view: View) {
        val context = activity as MainActivity
        context.setSupportActionBar(view.findViewById(R.id.bottom_app_bar))
        setHasOptionsMenu(true)

    }

    private fun Fragment.toast(string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 250)
            show()
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
