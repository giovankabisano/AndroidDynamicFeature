package com.giovankabisano.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onboarding.R
import kotlinx.android.synthetic.main.fragment_third_onboarding.*

class ThirdOnboardingFragment : Fragment(R.layout.fragment_third_onboarding) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        confirmButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}