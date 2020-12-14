package com.lansa.extensive.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import com.lansa.extensive.Utils.DEFAULT_FADE_IN_DURATION
import com.lansa.extensive.classes.ViewState


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
    this.makeInvisible()
    Handler(Looper.getMainLooper()).postDelayed({
        this.startAnimation(AlphaAnimation(0F, 1F).apply {
            duration = fadeDuration
            fillAfter = true
        })
        this.makeVisible()
    }, haltTime)
}

fun View.fadeOut(
    haltTime: Long = DEFAULT_FADE_IN_DURATION,
    fadeDuration: Long = DEFAULT_FADE_IN_DURATION
) {
    this.makeVisible()
    Handler(Looper.getMainLooper()).postDelayed({
        this.startAnimation(AlphaAnimation(0F, 1F).apply {
            duration = fadeDuration
            fillAfter = true
        })
        this.makeInvisible()
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
            ViewState.GONE -> makeGone()
            ViewState.INVISIBLE -> makeInvisible()
            ViewState.VISIBLE -> makeVisible()
        }
    } else {
        when (falseCondition) {
            ViewState.GONE -> makeGone()
            ViewState.INVISIBLE -> makeInvisible()
            ViewState.VISIBLE -> makeVisible()
        }
    }
}

fun View.makeGone() {
    if (isNotGone) {
        visibility = View.GONE
    }
}

fun View.makeInvisible() {
    if (isNotVisible) {
        visibility = View.INVISIBLE
    }
}

fun View.makeVisible() {
    if (isNotInvisible) {
        visibility = View.VISIBLE
    }
}

/*
fun View.visible(animate: Boolean = true) {
    if (animate) {
        animate().alpha(1f).setDuration(300).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                visibility = View.VISIBLE
            }
        })
    } else {
        visibility = View.VISIBLE
    }
}

/** Set the View visibility to INVISIBLE and eventually animate view alpha till 0% */
fun View.invisible(animate: Boolean = true) {
    hide(View.INVISIBLE, animate)
}

/** Set the View visibility to GONE and eventually animate view alpha till 0% */
fun View.gone(animate: Boolean = true) {
    hide(View.GONE, animate)
}

/** Convenient method that chooses between View.visible() or View.invisible() methods */
fun View.visibleOrInvisible(show: Boolean, animate: Boolean = true) {
    if (show) visible(animate) else invisible(animate)
}

/** Convenient method that chooses between View.visible() or View.gone() methods */
fun View.visibleOrGone(show: Boolean, animate: Boolean = true) {
    if (show) visible(animate) else gone(animate)
}

private fun View.hide(hidingStrategy: Int, animate: Boolean = true) {
    if (animate) {
        animate().alpha(0f).setDuration(300).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                visibility = hidingStrategy
            }
        })
    } else {
        visibility = hidingStrategy
    }
}*/