package com.fungo.player.ui.main


import com.fungo.baselib.manager.ThreadManager
import com.fungo.baseuilib.recycler.BaseRecyclerContract
import com.fungo.player.utils.VideoUtils

/**
 * @author Pinger
 * @since 2018/9/23 上午11:45
 */
class MainPresenter(private val mainView: BaseRecyclerContract.View) : BaseRecyclerContract.Presenter {


    /**
     * 查询本地视频数据
     */
    override fun loadData(page: Int) {
        ThreadManager.runOnSubThread(Runnable {
            val videoList = VideoUtils.queryVideoList(mainView.getContext())
            ThreadManager.runOnUIThread(Runnable {
                mainView.showContent(videoList)
            })
        })
    }
}