package com.fungo.player.ui.main

import com.fungo.baseuilib.activity.BaseSwipeBackActivity
import com.fungo.baseuilib.utils.StatusBarUtils
import com.fungo.funplayer.controller.StandardPlayerController
import com.fungo.funplayer.player.FunPlayerManager
import com.fungo.player.dao.VideoEntity
import com.fungo.player.helper.IntentContent
import com.thunder.player.R
import kotlinx.android.synthetic.main.activity_video_play.*

/**
 * @author Pinger
 * @since 2018/9/30 下午7:30
 */
class VideoPlayActivity : BaseSwipeBackActivity() {

    override fun isShowToolBar(): Boolean = false

    override fun getContentResID(): Int = R.layout.activity_video_play

    override fun initContentView() {
        StatusBarUtils.setFullScreen(this)
        val videoEntity = intent.getParcelableExtra<VideoEntity>(IntentContent.KEY_VIDEO_ENTITY)
        val controller = StandardPlayerController(this)
        controller.setTitle(videoEntity.videoName)
        funplayer.setController(controller)
        funplayer.setUrl(videoEntity.videoPath)

        funplayer.start()
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