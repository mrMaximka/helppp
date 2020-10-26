package com.example.myapplication

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetDecoration(private var  offset: Int) : RecyclerView.ItemDecoration( ) {

    override fun getItemOffsets(outRect: Rect,
        view: View, parent: RecyclerView, state: RecyclerView.State) {

        val position = parent.getChildAdapterPosition(view)

            when(position % 3) {
            0 -> {
                outRect.left = offset
                outRect.right = offset
            }
            1 -> {
                outRect.left = offset
                outRect.right = offset / 2
            }
            2 -> {
                outRect.left = offset / 2
                outRect.right = offset
            }
        }

        outRect.bottom = offset
        if(position == 0) {
            outRect.top = offset
        }
    }
}