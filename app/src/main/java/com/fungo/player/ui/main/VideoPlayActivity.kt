package com.fungo.player.ui.main

import com.fungo.baselib.base.basic.BaseActivity
import com.fungo.baselib.utils.StatusBarUtils
import com.fungo.funplayer.controller.StandardPlayerController
import com.fungo.funplayer.player.FunPlayerManager
import com.thunder.player.R
import com.fungo.player.dao.VideoEntity
import com.fungo.player.helper.IntentContent
import kotlinx.android.synthetic.main.activity_video_play.*

/**
 * @author Pinger
 * @since 2018/9/30 下午7:30
 */
class VideoPlayActivity(override val layoutResID: Int = R.layout.activity_video_play) : BaseActivity() {


    override fun initView() {
        StatusBarUtils.setFullScreenMode(this)
        val videoEntity = intent.getParcelableExtra<VideoEntity>(IntentContent.KEY_VIDEO_ENTITY)
        val controller = StandardPlayerController(this)
        controller.setTitle(videoEntity.videoName)
        funplayer.setController(controller)
        funplayer.setUrl(videoEntity.videoPath)

        funplayer.start()
    }

    override fun isSwipeBackEnable(): Boolean {
        return false
    }


    override fun onResume() {
        super.onResume()
        funplayer?.resume()
    }

    override fun onStop() {
        super.onStop()
        funplayer?.stopPlayback()
    }


    override fun onDestroy() {
        super.onDestroy()
        funplayer?.release()
    }

    override fun onBackPressedSupport() {
        if (!FunPlayerManager.instance.onBackPressed()) {
            super.onBackPressedSupport()
        }
    }
}