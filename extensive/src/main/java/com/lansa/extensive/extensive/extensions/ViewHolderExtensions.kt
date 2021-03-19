package com.lansa.extensive.extensive.extensions

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.annotation.*
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.ViewHolder.color(@ColorRes value: Int): Int {
    return this.itemView.context.color(value)
}

fun RecyclerView.ViewHolder.dimen(@DimenRes value: Int): Float {
    return this.itemView.context.dimen(value)
}

fun RecyclerView.ViewHolder.drawable(@DrawableRes value: Int): Drawable? {
    return this.itemView.context.drawable(value)
}

fun RecyclerView.ViewHolder.goTo(id: Int, bundle: Bundle? = null, navOptions: NavOptions? = null, navExtras: Navigator.Extras? = null) {
    itemView.goTo(id, bundle, navOptions, navExtras)
}

fun RecyclerView.ViewHolder.goTo(navDirections: NavDirections) {
    itemView.goTo(navDirections)
}

fun RecyclerView.ViewHolder.plural(@PluralsRes value: Int, amount: Int): String {
    return this.itemView.context.plural(value, amount)
}

fun RecyclerView.ViewHolder.string(@StringRes value: Int): String {
    return this.itemView.context.string(value)
}