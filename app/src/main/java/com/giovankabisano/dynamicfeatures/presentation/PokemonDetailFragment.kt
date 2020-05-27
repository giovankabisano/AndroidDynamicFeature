package com.giovankabisano.dynamicfeatures.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import androidx.navigation.fragment.findNavController
import com.giovankabisano.dynamicfeatures.R
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class PokemonDetailFragment : Fragment(R.layout.fragment_pokemon_detail) {

    private val sharedPreferenceViewModel by sharedViewModel<SharedPreferenceViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * When the user never open this page, then we will show onboarding page.
         */
        if (sharedPreferenceViewModel.shouldShowOnboardingPage()) {
            openOnboardingPage()
            sharedPreferenceViewModel.setOnboardingPageAsShown()
        }
        /**
         * Setup back button.
         * Navigate up (to previous page) when back button clicked.
         */
        back_button.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    /**
     * Mainly, this function will make the user navigated to Onboarding page.
     * When the user still don't have onboarding feature on the phone, then we will download that feature from playstore.
     *
     * Note: If you don't have playstore account or want to test the dynamic feature, you can execute this command
     *       "gradlew installApkSplitsForTestDebug"
     */
    private fun openOnboardingPage() {
        val installMonitor = DynamicInstallMonitor()
        val dynamicExtras = DynamicExtras.Builder()
            .setInstallMonitor(installMonitor)
            .build()

        findNavController().navigate(
            R.id.pokemonDetailFragment_to_onboardingFragment,
            null,
            null,
            dynamicExtras
        )

        if (installMonitor.isInstallRequired) {
            progress_bar.visibility = View.VISIBLE
            observeInstallationState(installMonitor)
        }
    }

    private fun observeInstallationState(installMonitor: DynamicInstallMonitor) {
        installMonitor.status.observe(
            viewLifecycleOwner,
            object : Observer<SplitInstallSessionState> {
                override fun onChanged(state: SplitInstallSessionState) {
                    /**
                     * Open onboarding page when the modules have been installed.
                     */
                    if (state.status() == SplitInstallSessionStatus.INSTALLED) {
                        progress_bar.visibility = View.GONE
                        openOnboardingPage()
                    }

                    /**
                     * Delete observer after the session have been finished
                     */
                    if (state.hasTerminalStatus()) {
                        installMonitor.status.removeObserver(this)
                    }
                }
            })
    }

}