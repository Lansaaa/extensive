package com.lansa.extensive.extensions

import android.os.Bundle
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun Fragment.goBack() {
    view?.goBack()
}

fun Fragment.goBackOnDeviceBackPressed(value: Boolean = true) {
    if (value) {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            goBack()
        }
    }
}

fun Fragment.goTo(
    id: Int,
    bundle: Bundle? = null,
    options: NavOptions? = null,
    extras: Navigator.Extras? = null
) {
    view?.goTo(id, bundle, options, extras)
}

fun Fragment.goTo(navDirections: NavDirections) {
    view?.goTo(navDirections)
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Fragment.showKeyboard() {
    view?.let { activity?.showKeyboard() }
}


