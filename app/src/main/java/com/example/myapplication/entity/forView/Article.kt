package com.example.myapplication.entity.forView

import android.os.Build
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.ItemType
import com.example.myapplication.R
import com.example.myapplication.ViewHolderFactory



class Article(private var text: String, private var img: Int) : ItemType {

    private var sizeForm: Int = ItemType.SMALL_FORM

    override fun getSizeForm( ) = sizeForm

    override fun setSizeForm(sizeForm: Int) {
        this.sizeForm = sizeForm
    }

    override fun getItemViewType( ): Int {
        return ItemType.ARTICLE_TYPE
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?) {
        val articleViewHolder: ViewHolderFactory.ArticleViewHolder =
            viewHolder as ViewHolderFactory.ArticleViewHolder


        if (sizeForm == ItemType.BIG_FORM) {
            (articleViewHolder.imageView?.layoutParams as ConstraintLayout.LayoutParams)
                .dimensionRatio = "h, 1:1"

            setTextStyle(articleViewHolder.textView, R.style.general_titleArticleBig)
        } else {
            (articleViewHolder.imageView?.layoutParams as ConstraintLayout.LayoutParams)
                .dimensionRatio = "h, 175:290"

            setTextStyle(articleViewHolder.textView, R.style.general_titleArticleSmall)
        }

        articleViewHolder.textView?.text = text
        Glide.with(articleViewHolder.imageView?.context).load(img).into(articleViewHolder.imageView)

    }


    fun setTextStyle(textView: TextView?, idStyle: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            textView?.setTextAppearance(idStyle)
        } else {
            textView?.setTextAppearance(textView.context, idStyle)
        }
    }
}
