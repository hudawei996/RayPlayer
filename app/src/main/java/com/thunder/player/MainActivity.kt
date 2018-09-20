package com.thunder.player

import com.fungo.baselib.base.basic.BaseActivity
import com.fungo.funplayer.controller.StandardPlayerController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity(override val layoutResID: Int = R.layout.activity_main) : BaseActivity() {

    private var mUrl = "http://221.228.226.5/14/z/w/y/y/zwyyobhyqvmwslabxyoaixvyubmekc/sh.yinyuetai.com/4599015ED06F94848EBF877EAAE13886.mp4"


    override fun initData() {
        val controller = StandardPlayerController(this)

        controller.setTitle("这是点播")
        funPlayer.setController(controller)
        funPlayer.setUrl(mUrl)
        funPlayer.start()

        setSwipeBackEnable(false)
    }

    override fun onDestroy() {
        funPlayer?.release()
        super.onDestroy()
    }

    override fun onStop() {
        funPlayer?.stopPlayback()
        super.onStop()
    }
}
