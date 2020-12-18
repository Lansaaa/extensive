package com.lansa.extensive.extensive.extensions

import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment

fun FragmentManager.detachNavHostFragment(navHostFragment: NavHostFragment) {
    beginTransaction()
        .detach(navHostFragment)
        .commitNow()
}

fun FragmentManager.attachNavHostFragment(
    navHostFragment: NavHostFragment, isPrimaryNavFragment: Boolean
) {
    beginTransaction()
        .attach(navHostFragment)
        .apply {
            if (isPrimaryNavFragment) {
                setPrimaryNavigationFragment(navHostFragment)
            }
        }
        .commitNow()

}

fun FragmentManager.obtainNavHostFragment(
    fragmentTag: String,
    navGraphId: Int,
    containerId: Int
): NavHostFragment {
    val existingFragment = findFragmentByTag(fragmentTag) as NavHostFragment?
    existingFragment?.let { return it }

    val navHostFragment = NavHostFragment.create(navGraphId)
    beginTransaction()
        .add(containerId, navHostFragment, fragmentTag)
        .commitNow()
    return navHostFragment
}

fun FragmentManager.isOnBackStack(backStackName: String): Boolean {
    val backStackCount = backStackEntryCount
    for (index in 0 until backStackCount) {
        if (getBackStackEntryAt(index).name == backStackName) {
            return true
        }
    }
    return false
}