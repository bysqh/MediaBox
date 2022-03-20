package com.su.mediabox.view.viewcomponents

import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.su.mediabox.databinding.ViewComponentVideoGridBinding
import com.su.mediabox.pluginapi.v2.been.TagFlowData
import com.su.mediabox.view.adapter.type.TypeViewHolder
import com.su.mediabox.view.adapter.type.initTypeList
import com.su.mediabox.view.adapter.type.typeAdapter


class TagFlowViewHolder private constructor(private val binding: ViewComponentVideoGridBinding) :
    TypeViewHolder<TagFlowData>(binding.root) {

    constructor(parent: ViewGroup) : this(
        ViewComponentVideoGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ) {
        binding.root.apply {
            layoutManager = FlexboxLayoutManager(binding.root.context).apply {
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.CENTER
            }
        }.initTypeList { }
    }

    override fun onBind(data: TagFlowData) {
        binding.root.typeAdapter().submitList(data.tagList)
    }
}