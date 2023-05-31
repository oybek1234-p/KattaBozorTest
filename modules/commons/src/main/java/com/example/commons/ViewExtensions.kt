package com.example.commons

import android.view.View
import android.view.ViewGroup

fun View.visibleOrGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun ViewGroup.hasSingleChild(): Boolean {
    return childCount == 1
}