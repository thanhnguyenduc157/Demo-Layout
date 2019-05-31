package com.dwarvesf.layoutapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.ViewTreeObserver




class MainActivity : AppCompatActivity() {

    private var heightRed:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()
    }

    private fun setUpView()
    {
        clRoot.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                if (clRoot.viewTreeObserver.isAlive())
                    clRoot.viewTreeObserver.removeOnPreDrawListener(this)

                heightRed  = clRed.height
                setSizeForYellowView()
                setSizeForOrangeView()
                return true
            }
        })

    }

    private fun setSizeForYellowView()
    {
        val ivParams = tvPink.layoutParams
        ivParams.height = heightRed/2
        tvPink.layoutParams = ivParams
    }

    private fun setSizeForOrangeView()
    {
        val ivParams = clOrange.layoutParams
        ivParams.width = heightRed
        ivParams.height = heightRed
        clOrange.layoutParams = ivParams
    }
}
