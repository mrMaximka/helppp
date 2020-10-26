package com.example.myapplication

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.ViewHolderFactory.create


class TestAdapter(private val dataSet: List<ItemType>) : RecyclerView.Adapter<ViewHolder>() {
    fun setSizeForm(position: Int, type: Int){
        dataSet[position].setSizeForm(type)
    }

    override fun getItemViewType(position: Int) = dataSet[position].getItemViewType()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return create(parent, viewType)!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        dataSet[position].onBindViewHolder(holder)
    }

    override fun getItemCount()= dataSet.size

}