package com.giovankabisano.dynamicfeatures

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

//        mapOf(
//            Pair(R.id.haha, R.id.customMonitorFragment)
//        ).forEach { (viewId, destinationId) ->
//            view.findViewById<Button>(viewId).setOnClickListener {
//                navController.navigate(destinationId)
//            }
//        }

    }

}