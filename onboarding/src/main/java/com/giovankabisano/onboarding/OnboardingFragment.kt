package com.giovankabisano.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.onboarding.R
import com.giovankabisano.dynamicfeatures.presentation.ListPagerAdapter
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
    }

    /**
     * Create view pager that consist of 3 pages.
     */
    private fun setupViewPager() {
        view_pager.adapter = ListPagerAdapter(childFragmentManager).apply {
            setFragments(
                listOf(
                    FirstOnboardingFragment(),
                    SecondOnboardingFragment(),
                    ThirdOnboardingFragment()
                )
            )
        }
    }
}