package com.lansa.extensive.extensive.extensions

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import com.lansa.extensive.extensive.Utils.DEFAULT_FADE_IN_DURATION
import com.lansa.extensive.extensive.classes.ViewState


val View.isGone: Boolean
    get() = (visibility == View.GONE)

val View.isInvisible: Boolean
    get() = (visibility == View.INVISIBLE)

val View.isVisible: Boolean
    get() = (visibility == View.VISIBLE)

val View.isNotGone: Boolean
    get() = !isGone

val View.isNotInvisible: Boolean
    get() = !isInvisible

val View.isNotVisible: Boolean
    get() = !isVisible

fun View.fadeIn(
    haltTime: Long = DEFAULT_FADE_IN_DURATION,
    fadeDuration: Long = DEFAULT_FADE_IN_DURATION
) {
    this.invisible()
    Handler(Looper.getMainLooper()).postDelayed({
        this.startAnimation(AlphaAnimation(0F, 1F).apply {
            duration = fadeDuration
            fillAfter = true
        })
        this.visible()
    }, haltTime)
}

fun View.fadeOut(
    haltTime: Long = DEFAULT_FADE_IN_DURATION,
    fadeDuration: Long = DEFAULT_FADE_IN_DURATION
) {
    this.visible()
    Handler(Looper.getMainLooper()).postDelayed({
        this.startAnimation(AlphaAnimation(0F, 1F).apply {
            duration = fadeDuration
            fillAfter = true
        })
        this.invisible()
    }, haltTime)
}

fun View.goBack() {
    findNavController().popBackStack()
}

fun View.goTo(
    id: Int,
    bundle: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    findNavController().navigate(id, bundle, navOptions, navExtras)
}

fun View.goTo(navDirections: NavDirections) {
    findNavController().navigate(navDirections)
}

fun View.handleVisibility(value: Boolean, trueCondition: ViewState, falseCondition: ViewState) {
    if (value) {
        when (trueCondition) {
            ViewState.GONE -> gone()
            ViewState.INVISIBLE -> invisible()
            ViewState.VISIBLE -> visible()
        }
    } else {
        when (falseCondition) {
            ViewState.GONE -> gone()
            ViewState.INVISIBLE -> invisible()
            ViewState.VISIBLE -> visible()
        }
    }
}

fun View.gone() {
    if (isNotGone) {
        visibility = View.GONE
    }
}

fun View.invisible() {
    if (isNotVisible) {
        visibility = View.INVISIBLE
    }
}

fun View.visible() {
    if (isNotInvisible) {
        visibility = View.VISIBLE
    }
}