package com.thunder.player.ui.main


import com.fungo.baselib.base.recycler.BaseRecyclerContract
import com.fungo.baselib.manager.ThreadManager
import com.thunder.player.utils.VideoUtils

/**
 * @author Pinger
 * @since 2018/9/23 上午11:45
 */
class MainPresenter(private val mainView: BaseRecyclerContract.View) : BaseRecyclerContract.Presenter {


    /**
     * 查询本地视频数据
     */
    override fun loadData(page: Int) {
      /*  println("----- 搜索开始 -----")

        ThreadManager.runOnSubThread(Runnable {
            val videoList = VideoUtils.queryVideoList(mainView)
            ThreadManager.runOnUIThread(Runnable {

                println("----- 搜索结束 -----")
                mainView.showContent(page, videoList)
            })
        })
*/
    }
}