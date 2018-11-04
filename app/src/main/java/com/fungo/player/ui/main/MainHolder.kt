package com.fungo.player.ui.main

import android.content.Intent
import android.view.ViewGroup
import com.fungo.baseuilib.recycler.BaseViewHolder
import com.fungo.baseuilib.recycler.multitype.MultiTypeViewHolder
import com.fungo.imagego.loadImage
import com.fungo.player.dao.VideoEntity
import com.fungo.player.helper.IntentContent
import com.thunder.player.R

/**
 * @author Pinger
 * @since 2018/9/23 上午11:56
 */
class MainHolder : MultiTypeViewHolder<VideoEntity, MainHolder.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(parent)
    }

    class ViewHolder(parent: ViewGroup) : BaseViewHolder<VideoEntity>(parent, R.layout.holder_main) {

        override fun onBindData(data: VideoEntity) {
            setText(R.id.tvName, data.videoName)

            setText(R.id.tvDuration, data.videoDuration.toString())

            loadImage(data.videoThumbPath, findView(R.id.ivThumb))

        }

        override fun onItemClick(data: VideoEntity) {
            val intent = Intent(getContext(), VideoPlayActivity::class.java)
            intent.putExtra(IntentContent.KEY_VIDEO_ENTITY, data)
            getContext()?.startActivity(intent)
        }
    }
}