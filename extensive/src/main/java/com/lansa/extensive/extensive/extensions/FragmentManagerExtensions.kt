package com.lansa.extensive.extensive.extensions

import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment


fun FragmentManager.isOnBackStack(backStackName: String): Boolean {
    val backStackCount = backStackEntryCount
    for (index in 0 until backStackCount) {
        if (getBackStackEntryAt(index).name == backStackName) {
            return true
        }
    }
    return false
}