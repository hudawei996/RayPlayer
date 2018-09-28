package com.thunder.player.ui.main

import android.content.Context
import android.view.ViewGroup
import android.view.ViewParent
import com.fungo.baselib.base.recycler.BaseRecyclerAdapter
import com.fungo.baselib.base.recycler.BaseViewHolder
import com.fungo.baselib.base.recycler.multitype.MultiTypeAdapter
import com.fungo.baselib.base.recycler.multitype.MultiTypeViewHolder
import com.thunder.player.R

/**
 * @author Pinger
 * @since 2018/9/23 上午11:56
 */
class MainHolder : MultiTypeViewHolder<MainBean, MainHolder.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(parent)
    }

    class ViewHolder(parent: ViewGroup) : BaseViewHolder<MainBean>(parent, R.layout.holder_main) {

        override fun onBindData(data: MainBean) {
            setText(R.id.tvName, data.name)
        }

    }
}