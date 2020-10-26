package com.example.myapplication.entity.forView

import android.graphics.Color
import android.os.Build
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.ItemType
import com.example.myapplication.R
import com.example.myapplication.StatusBroadcast
import com.example.myapplication.ViewHolderFactory


class Broadcast(private var text: String, private var img: Int,
                private var isStart: StatusBroadcast) : ItemType {

    private var sizeForm: Int = ItemType.SMALL_FORM

    override fun getSizeForm( ) = sizeForm

    override fun setSizeForm(sizeForm: Int){
        this.sizeForm = sizeForm
    }

    override fun getItemViewType( ): Int {
        return ItemType.BROADCAST_TYPE
    }


    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?) {
        val broadcastViewHolder: ViewHolderFactory.BroadcastViewHolder =
            viewHolder as ViewHolderFactory.BroadcastViewHolder

        if(isStart == StatusBroadcast.BroadcastStart) {
            broadcastViewHolder.liveImgView?.setBackgroundResource(R.drawable.live_start)
            broadcastViewHolder.liveImgView?.setTextColor(
                ContextCompat.getColor(broadcastViewHolder.liveImgView!!.context, R.color.white)
            )
            broadcastViewHolder.liveTxtView?.setText(R.string.live_start)
        } else {
            broadcastViewHolder.liveImgView?.setBackgroundResource(R.drawable.live_end)
            broadcastViewHolder.liveImgView?.setTextColor(
                ContextCompat.getColor(broadcastViewHolder.liveImgView!!.context, R.color.black)
            )
            broadcastViewHolder.liveTxtView?.setText(R.string.live_end)
        }


        if (sizeForm == ItemType.BIG_FORM) {
            (broadcastViewHolder.imageView?.layoutParams as ConstraintLayout.LayoutParams)
                .dimensionRatio = "h, 1:1"

            setTextStyle(broadcastViewHolder.textView, R.style.general_titleNewsBig)
        } else {
            (broadcastViewHolder.imageView?.layoutParams as ConstraintLayout.LayoutParams)
                .dimensionRatio = "h, 175:290"

            setTextStyle(broadcastViewHolder.textView, R.style.general_titleNewsSmall)
        }

        broadcastViewHolder.textView?.text = text
        Glide.with(broadcastViewHolder.imageView?.context).load(img).into(broadcastViewHolder.imageView)

    }

    fun setTextStyle(textView: TextView?, idStyle: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            textView?.setTextAppearance(idStyle)
        } else {
            textView?.setTextAppearance(textView.context, idStyle)
        }
    }

}
