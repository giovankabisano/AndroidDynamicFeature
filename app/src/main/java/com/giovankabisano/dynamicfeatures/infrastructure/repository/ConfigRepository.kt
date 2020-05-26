package com.giovankabisano.dynamicfeatures.infrastructure.repository

import android.content.Context
import android.preference.PreferenceManager

class ConfigRepository(context: Context) {

    companion object {
        private const val ONBOARDING_PAGE_SHOWN = "ONBOARDING_PAGE_SHOWN"
    }

    private val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)

    fun shouldShowOnboardingPage(): Boolean = !sharedPreference.getBoolean(ONBOARDING_PAGE_SHOWN, false)

    fun setOnboardingPageAsShown() = sharedPreference.edit().putBoolean(ONBOARDING_PAGE_SHOWN, true).apply()

}