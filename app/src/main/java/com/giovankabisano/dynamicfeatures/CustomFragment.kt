package com.giovankabisano.dynamicfeatures

import android.os.Bundle
import android.view.View
import android.widget.Button
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
        val navController = findNavController()

        mapOf(
            Pair(R.id.some_button, R.id.featureFragment)
        ).forEach { (targetViewId, destinationId) ->
            view.findViewById<Button>(targetViewId).setOnClickListener { button ->
                val installMonitor = DynamicInstallMonitor()
                val dynamicExtras = DynamicExtras.Builder()
                    .setInstallMonitor(installMonitor)
                    .build()

                navController.navigate(destinationId, null, null, dynamicExtras)

                if (installMonitor.isInstallRequired) {
                    observeInstallationState(installMonitor, button)
                }
            }
        }
    }

    private fun observeInstallationState(installMonitor: DynamicInstallMonitor, button: View?) {
        installMonitor.status.observe(
            viewLifecycleOwner,
            object : Observer<SplitInstallSessionState> {
                override fun onChanged(state: SplitInstallSessionState) {
                    (button as Button).text = when (state.status()) {
                        SplitInstallSessionStatus.INSTALLED -> "R.string.launch"
                        SplitInstallSessionStatus.FAILED -> "R.string.installation_failed"
                        else -> "R.string.installing"
                    }

                    if (state.hasTerminalStatus()) {
                        installMonitor.status.removeObserver(this)
                    }
                }
            })
    }

}