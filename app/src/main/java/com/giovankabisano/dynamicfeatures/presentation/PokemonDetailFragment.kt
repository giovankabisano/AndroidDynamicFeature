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
import org.koin.android.viewmodel.ext.android.sharedViewModel

class PokemonDetailFragment : Fragment(R.layout.fragment_pokemon_detail) {

    private val sharedPreferenceViewModel by sharedViewModel<SharedPreferenceViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (sharedPreferenceViewModel.shouldShowOnboardingPage()) {
            openOnboardingPage()
            sharedPreferenceViewModel.setOnboardingPageAsShown()
        }
    }

    private fun openOnboardingPage() {
        val installMonitor = DynamicInstallMonitor()
        val dynamicExtras = DynamicExtras.Builder()
            .setInstallMonitor(installMonitor)
            .build()

        findNavController().navigate(R.id.featureFragment, null, null, dynamicExtras)

        if (installMonitor.isInstallRequired) {
            observeInstallationState(installMonitor)
        }
    }

    private fun observeInstallationState(installMonitor: DynamicInstallMonitor) {
        installMonitor.status.observe(
            viewLifecycleOwner,
            object : Observer<SplitInstallSessionState> {
                override fun onChanged(state: SplitInstallSessionState) {
                    if (state.status() == SplitInstallSessionStatus.INSTALLED) {
                        openOnboardingPage()
                    }

                    if (state.hasTerminalStatus()) {
                        installMonitor.status.removeObserver(this)
                    }
                }
            })
    }

}