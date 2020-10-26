package com.example.myapplication

import android.content.Context
import com.example.myapplication.entity.forView.Article
import com.example.myapplication.entity.forView.Broadcast
import com.example.myapplication.entity.forView.News
import com.example.myapplication.entity.forView.PhotoAlbum


object Data {
    fun getItemsList(applicationContext: Context) = listOf(
        Broadcast(
            "Ковалев против Канело. Бой за пояс WBO",
            R.drawable.broadcast,
            StatusBroadcast.BroadcastStart
        ),
        News(
            "Егоров совсем поплыл. Считает бесспорным, что Вилков отсудил хорошо, и ждет вопросов про туалет",
            R.drawable.news2,
            applicationContext
        ),
        News(
            "Световые маски для лица против старения и прыщей: как это работает. Их фанатка — Виктория Бекхэм",
            R.drawable.news1,
            applicationContext
        ),

        PhotoAlbum(
            "Шоу Ларссона, объятия Карпина с Гулиевым и подарок ребенку от Джикии. Победа «Спартака» — в кадрах",
            R.drawable.photoalbum
        ),

        Article(
            "Шипулин в Госдуме уже полтора месяца: перечислил половину зарплаты ветеранам, помог матери-одиночке",
            R.drawable.article1
        ),
        Article(
            "Американцев сделали крайними в белорусском клубе. «Динамо» вернулось на дно КХЛ и нашло виноватых",
            R.drawable.article2
        ),
        Broadcast(
            "Ковалев против Канело. Бой за пояс WBO",
            R.drawable.broadcast,
            StatusBroadcast.BroadcastEnd
        )
    )

}