package com.thunder.player.ui.main


import com.fungo.baselib.base.recycler.BaseRecyclerContract

/**
 * @author Pinger
 * @since 2018/9/23 上午11:45
 */
class MainPresenter(val mainView: BaseRecyclerContract.View) : BaseRecyclerContract.Presenter {


    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun loadData(page: Int) {

        for (i in 0..20) {
            mainView.addItem(MainBean("我是视频$i"))
        }

    }
}