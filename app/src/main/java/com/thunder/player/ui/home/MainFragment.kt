package com.thunder.player.ui.home

import com.fungo.baselib.base.page.BasePageFragment
import com.fungo.funplayer.controller.StandardPlayerController
import com.thunder.player.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * @author Pinger
 * @since 2018/9/20 下午3:41
 */
class MainFragment : BasePageFragment() {

    override fun getContentResId(): Int {
        return R.layout.fragment_main
    }

    override fun getPageTitle(): String? {
        return getString(R.string.app_name)
    }

    override fun initView() {
        val controller = StandardPlayerController(context!!)

        funplayer.setController(controller)
        funplayer.setUrl("http://down.amcdnship.com/mp4/160306/ONED-927.mp4")
        funplayer.startPlay()
    }

    override fun onDestroy() {
        funplayer.release()
        super.onDestroy()
    }

    override fun onStop() {
        funplayer.stopPlayback()
        super.onStop()
    }
}