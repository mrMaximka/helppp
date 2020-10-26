package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

object ViewHolderFactory {
    fun create(parent: ViewGroup, viewType: Int) = when (viewType) {
        ItemType.NEWS_TYPE -> {
            NewsViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_news, parent, false)
            )
        }
        ItemType.ARTICLE_TYPE -> {
            ArticleViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_article, parent, false)
            )
        }
        ItemType.BROADCAST_TYPE -> {
            BroadcastViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_broadcast, parent, false)
            )
        }
        ItemType.PHOTO_ALBUM_TYPE -> {
            PhotoAlbumViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_photo_album, parent, false)
            )
        }
        else -> null
    }




    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = itemView.findViewById(R.id.id_text_news)
        var imageView: ImageView? = itemView.findViewById(R.id.id_img_news)
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = itemView.findViewById(R.id.id_txt_article)
        var imageView: ImageView? = itemView.findViewById(R.id.id_img_article)
    }

    class BroadcastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = itemView.findViewById(R.id.id_text_broadcast)
        var imageView: ImageView? = itemView.findViewById(R.id.id_img_broadcast)

        var liveImgView: TextView? = itemView.findViewById(R.id.id_live_img)
        var liveTxtView: TextView? = itemView.findViewById(R.id.id_live_txt)
    }

    class PhotoAlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = itemView.findViewById(R.id.id_txt_photo_alb)
        var imageView: ImageView? = itemView.findViewById(R.id.id_img_photo_alb)
        var imageBackView: ImageView? = itemView.findViewById(R.id.id_back_photo_alb)
        //
        // var textCountPhotoView: TextView? = itemView.findViewById(R.id.id_txt_count_photo)
        //
    }

}