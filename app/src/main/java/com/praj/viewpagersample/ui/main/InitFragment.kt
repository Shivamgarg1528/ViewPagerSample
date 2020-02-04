package com.praj.viewpagersample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.praj.viewpagersample.MainActivity
import com.praj.viewpagersample.R
import kotlinx.android.synthetic.main.fragment_ui_3.*

class InitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ui_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // Log.d(MainActivity.TAG, getPrintableText())

        childFragmentManager.commit {
            val initFragment = CoreFragment.newInstance(arguments!!.getInt(ARG_SECTION_NUMBER))
            this.replace(container.id, initFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        val printableText = getPrintableText()
        Log.d(MainActivity.TAG, "onResume-->>>> $printableText")
    }

    override fun onPause() {
        super.onPause()
        val printableText = getPrintableText()
        Log.d(MainActivity.TAG, "onPause-->>>> $printableText")
    }

    private fun getPrintableText(): String {
        val index = arguments!!.getInt(ARG_SECTION_NUMBER)
        return "Init Fragment #$index"
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): InitFragment {
            return InitFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}