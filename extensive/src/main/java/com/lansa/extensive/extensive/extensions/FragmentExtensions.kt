package com.lansa.extensive.extensive.extensions

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.addCallback
import androidx.annotation.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController


fun Fragment.color(@ColorRes value: Int): Int {
    return requireContext().color(value)
}

fun Fragment.dimen(@DimenRes value: Int): Float {
    return requireContext().dimen(value)
}

fun Fragment.drawable(@DrawableRes value: Int): Drawable? {
    return requireContext().drawable(value)
}

fun Fragment.enableBackOnDeviceBackPressed(value: Boolean = true) {
    if (value) {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            goBack()
        }
    }
}

fun Fragment.goBack() {
    findNavController().popBackStack()
}

fun Fragment.goBackTo(value: Int, inclusive: Boolean) {
    findNavController().popBackStack(value, inclusive)
}

fun Fragment.goTo(id: Int, bundle: Bundle? = null, options: NavOptions? = null, extras: Navigator.Extras? = null) {
    view?.goTo(id, bundle, options, extras)
}

fun Fragment.goTo(navDirections: NavDirections) {
    view?.goTo(navDirections)
}


fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Fragment.plural(@PluralsRes value: Int, amount: Int): String {
    return requireContext().plural(value, amount)
}

fun Fragment.showKeyboard() {
    view?.let { activity?.showKeyboard() }
}

fun Fragment.string(@StringRes value: Int): String {
    return requireContext().string(value)
}

