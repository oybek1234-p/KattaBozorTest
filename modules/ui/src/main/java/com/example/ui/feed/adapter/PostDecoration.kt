package com.example.ui.feed.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

const val padding = 30

var postDecoration = object : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val params = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
        outRect.apply {
            if (params.spanIndex == 0) {
                left = padding
                right = padding / 2
            } else {
                left = padding / 2
                right = padding
            }
            top = padding
        }
    }
}