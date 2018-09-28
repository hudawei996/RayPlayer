package com.thunder.player.ui.main

import com.fungo.baselib.base.recycler.BaseRecyclerContract
import com.fungo.baselib.base.recycler.BaseRecyclerFragment

import com.thunder.player.R

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

        register(MainBean::class.java, MainHolder())
    }

    override fun isBackEnable(): Boolean = false

    override fun isSwipeBackEnable(): Boolean = false

}