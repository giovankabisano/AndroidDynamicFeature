package com.giovankabisano.dynamicfeatures.presentation

import androidx.lifecycle.ViewModel
import com.giovankabisano.dynamicfeatures.infrastructure.repository.ConfigRepository

class SharedPreferenceViewModel(
    private val configRepository: ConfigRepository
) : ViewModel() {
    fun shouldShowOnboardingPage(): Boolean = configRepository.shouldShowOnboardingPage()
    fun setOnboardingPageAsShown() = configRepository.setOnboardingPageAsShown()
}