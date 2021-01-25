package com.example.naterial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = getPreferences(MODE_PRIVATE)
        val themeID = sharedPref.getInt("THEMEID", 0)
        when(themeID)
        {
            R.id.t1->setTheme(R.style.Theme1)
            R.id.t2->setTheme(R.style.Theme2)
            R.id.t3->setTheme(R.style.Theme_Naterial)
            0->setTheme(R.style.Theme_Naterial)
        }

        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                    .commitNow()
        }
    }
}