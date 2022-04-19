package com.treech.custom.viewstudy.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.treech.custom.viewstudy.databinding.ItemGuideBinding

class GuideAdapter() : RecyclerView.Adapter<GuideAdapter.GuideViewHolder>() {

    private var titles = mutableListOf<String>()

    fun submitData(titles: MutableList<String>) {
        this.titles.clear()
        this.titles.addAll(titles)
        notifyDataSetChanged()
    }

    private var clickAction: (title: String, v: TextView, position: Int) -> Unit = { _, _, _ -> }

    fun setClickAction(clickAction: (title: String, v: TextView, position: Int) -> Unit) {
        this.clickAction = clickAction
    }

    inner class GuideViewHolder(private val binding: ItemGuideBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(position: Int) {
            Log.d("ygq", "position:$position,title:${titles[position]}")
            binding.tv.apply {
                text = titles[position]
                setOnClickListener { clickAction.invoke(titles[position], this, position) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        return GuideViewHolder(ItemGuideBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount() = titles.size

}