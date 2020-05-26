package com.giovankabisano.dynamicfeatures.presentation

import androidx.lifecycle.ViewModel
import com.giovankabisano.dynamicfeatures.infrastructure.repository.ConfigRepository

class SharedPreferenceViewModel(
    private val configRepository: ConfigRepository
) : ViewModel() {
    /**
     * Only show onboarding page once. That's why we save the flag in SharedPreference.
     */
    fun shouldShowOnboardingPage(): Boolean = configRepository.shouldShowOnboardingPage()
    fun setOnboardingPageAsShown() = configRepository.setOnboardingPageAsShown()
}