package com.giovankabisano.dynamicfeatures.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ListPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var _fragments: List<Fragment> = emptyList()

    override fun getCount(): Int {
        return _fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return _fragments[position]
    }

    fun setFragments(fragments: List<Fragment>) {
        _fragments = fragments
    }
}
