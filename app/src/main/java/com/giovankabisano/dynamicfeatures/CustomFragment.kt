package com.giovankabisano.dynamicfeatures

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import androidx.navigation.fragment.findNavController
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

class CustomFragment : Fragment(R.layout.fragment_custom) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openOnboardingPage()
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