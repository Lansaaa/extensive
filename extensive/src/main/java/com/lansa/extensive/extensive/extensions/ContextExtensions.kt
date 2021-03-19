package com.lansa.extensive.extensive.extensions

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.*
import androidx.core.content.ContextCompat


fun Context.color(@ColorRes value: Int): Int {
    return ContextCompat.getColor(this, value)
}

fun Context.dimen(@DimenRes value: Int): Float {
    return resources.getDimension(value)
}

fun Context.drawable(@DrawableRes value: Int): Drawable? {
    return ContextCompat.getDrawable(this, value)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.isAppInBackground(): Boolean {
    val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val runningProcesses = am.runningAppProcesses
    for (processInfo in runningProcesses) {
        if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
            for (activeProcess in processInfo.pkgList) {
                if (activeProcess == packageName) {
                    return false
                }
            }
        }
    }
    return true
}

fun Context.plural(@PluralsRes value: Int, amount: Int): String {
    return resources.getQuantityString(value, amount, amount)
}

fun Context.showKeyboard() {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

fun Context.string(@StringRes value: Int): String {
    return resources.getString(value)
}

fun Context.toast(value: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, value, Toast.LENGTH_LONG).show()
}
