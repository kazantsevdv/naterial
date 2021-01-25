package com.example.naterial

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {
    val Preff = "PREFF"

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chipGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.t1,R.id.t2,R.id.t3   -> setTheme(checkedId)
            }
        }
    }
    fun setTheme(id: Int){
        val sharedPref = activity?.getPreferences(MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putInt("THEMEID", id)
            apply()
        }
        chipGroup.findViewById<Chip>(id)?.let {
            it.isChecked = false
        }

        activity?.recreate()
    }
}
