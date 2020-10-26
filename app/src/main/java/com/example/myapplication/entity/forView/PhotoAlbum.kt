package com.example.myapplication.entity.forView

import android.os.Build
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.ItemType
import com.example.myapplication.R
import com.example.myapplication.ViewHolderFactory


class PhotoAlbum(private var text: String, private var img: Int) : ItemType {

    private var sizeForm: Int = ItemType.SMALL_FORM

    override fun getSizeForm( ) = sizeForm

    override fun setSizeForm(sizeForm: Int) {
        this.sizeForm = sizeForm
    }

    override fun getItemViewType( ): Int {
        return ItemType.PHOTO_ALBUM_TYPE
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?) {
        val albumViewHolder: ViewHolderFactory.PhotoAlbumViewHolder =
            viewHolder as ViewHolderFactory.PhotoAlbumViewHolder

        if (sizeForm == ItemType.BIG_FORM) {
            (albumViewHolder.imageBackView?.layoutParams as ConstraintLayout.LayoutParams)
                .dimensionRatio = "h, 1:1"

            setTextStyle(albumViewHolder.textView, R.style.general_titleArticleBig)
        } else {
            (albumViewHolder.imageBackView?.layoutParams as ConstraintLayout.LayoutParams)
                .dimensionRatio = "h, 175:290"

            setTextStyle(albumViewHolder.textView, R.style.general_titleArticleSmall)
        }

        albumViewHolder.textView?.text = text
        Glide.with(albumViewHolder.imageView?.context).load(img).into(albumViewHolder.imageView)
    }



    fun setTextStyle(textView: TextView?, idStyle: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            textView?.setTextAppearance(idStyle)
        } else {
            textView?.setTextAppearance(textView.context, idStyle)
        }
    }
}
