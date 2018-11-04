package com.fungo.player.ui.main

import com.fungo.baseuilib.recycler.BaseRecyclerContract
import com.fungo.baseuilib.recycler.BaseRecyclerFragment
import com.fungo.player.dao.VideoEntity
import com.thunder.player.R

/**
 * @author Pinger
 * @since 2018/9/20 下午3:41
 */
class MainFragment : BaseRecyclerFragment() {

    override fun getPresenter(): BaseRecyclerContract.Presenter = MainPresenter(this)

    override fun getPageTitle(): String? {
        return getString(R.string.app_name)
    }

    override fun initPageView() {
        register(VideoEntity::class.java, MainHolder())
    }


    override fun isEnableLoadmore(): Boolean = false


}