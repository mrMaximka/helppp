package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView


interface ItemType {
    fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?)
    fun getItemViewType( ): Int
    fun getSizeForm( ): Int
    fun setSizeForm(sizeForm: Int)

    companion object {
        val NEWS_TYPE = 0
        val ARTICLE_TYPE = 1
        val BROADCAST_TYPE = 2
        val PHOTO_ALBUM_TYPE = 3

        val SMALL_FORM = 4
        val BIG_FORM = 5
    }

}
