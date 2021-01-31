package com.lansa.extensive.extensive.extensions

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.ViewHolder.color(@ColorRes value: Int): Int {
    return this.itemView.context.color(value)
}

fun RecyclerView.ViewHolder.drawable(@DrawableRes value: Int): Drawable? {
    return this.itemView.context.drawable(value)
}

fun RecyclerView.ViewHolder.plural(@StringRes value: Int, amount: Int): String {
    return this.itemView.context.plural(value, amount)
}

fun RecyclerView.ViewHolder.string(@StringRes value: Int): String {
    return this.itemView.context.string(value)
}