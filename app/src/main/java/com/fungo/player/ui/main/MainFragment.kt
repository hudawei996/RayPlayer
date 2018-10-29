package com.fungo.player.ui.main

import com.fungo.baselib.base.recycler.BaseRecyclerContract
import com.fungo.baselib.base.recycler.BaseRecyclerFragment
import com.fungo.baselib.manager.ThreadManager

import com.thunder.player.R
import com.fungo.player.dao.VideoEntity
import com.fungo.player.utils.VideoUtils

/**
 * @author Pinger
 * @since 2018/9/20 下午3:41
 */
class MainFragment : BaseRecyclerFragment() {

    override fun getPresenter(): BaseRecyclerContract.Presenter {
        return MainPresenter(this)
    }

    override fun getPageTitle(): String? {
        return getString(R.string.app_name)
    }

    override fun initRecyclerView() {
        setPageTitleSize(18f)

        register(VideoEntity::class.java, MainHolder())
    }

    override fun isBackEnable(): Boolean = false

    override fun isSwipeBackEnable(): Boolean = false


    override fun initData() {
        showPageLoading()
        ThreadManager.runOnSubThread(Runnable {
            val videoList = VideoUtils.queryVideoList(context)
            ThreadManager.runOnUIThread(Runnable {
                showContent(0, videoList)
            })
        })

    }

}