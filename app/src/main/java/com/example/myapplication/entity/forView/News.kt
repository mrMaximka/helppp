package com.example.myapplication.entity.forView

import android.content.Context
import android.os.Build
import android.util.TypedValue
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.ItemType
import com.example.myapplication.R
import com.example.myapplication.ViewHolderFactory
import java.security.AccessController.getContext


class News(private var text: String, private var img: Int, private val context: Context) : ItemType {

    private var sizeForm: Int = ItemType.SMALL_FORM

    override fun getSizeForm( ) = sizeForm

    override fun setSizeForm(sizeForm: Int) {
        this.sizeForm = sizeForm
    }

    override fun getItemViewType( ): Int {
        return ItemType.NEWS_TYPE
    }


    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?) {
        val newsViewHolder: ViewHolderFactory.NewsViewHolder =
            viewHolder as ViewHolderFactory.NewsViewHolder

        if (sizeForm == ItemType.BIG_FORM) {
            (newsViewHolder.imageView?.layoutParams as ConstraintLayout.LayoutParams)
                .dimensionRatio = "h, 1:1"

            
//-------------------------
            /*val value = 200
            val dpValue = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value.toFloat(),
                getContext().getResources().getDisplayMetrics()
            ).toInt()*/
//-----------------------

            val padding_in_dp = 6 // 6 dps
//            val scale: Float =  getContext().getResources().getDisplayMetrics().density
            val scale: Float =  context.resources.displayMetrics.density
            val padding_in_px = (padding_in_dp * scale + 0.5f).toInt()



            //для этого
            newsViewHolder.textView?.setPadding(15, 0, 15,15)

            setTextStyle(newsViewHolder.textView, R.style.general_titleNewsBig)
        } else {
            (newsViewHolder.imageView?.layoutParams as ConstraintLayout.LayoutParams)
                .dimensionRatio = "h, 175:290"


            newsViewHolder.textView?.setPadding(14, 0, 14,14)
            setTextStyle(newsViewHolder.textView, R.style.general_titleNewsSmall)
        }

        newsViewHolder.textView?.text = text
        Glide.with(newsViewHolder.imageView?.context).load(img).into(newsViewHolder.imageView)
    }


    @Suppress("DEPRECATION")
    fun setTextStyle(textView: TextView?, idStyle: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            textView?.setTextAppearance(idStyle)
        } else {
            textView?.setTextAppearance(textView.context, idStyle)
        }
    }
}