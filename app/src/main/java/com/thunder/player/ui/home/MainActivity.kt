package com.thunder.player.ui.home

import android.os.Bundle
import com.fungo.baselib.base.page.BasePageActivity
import com.fungo.baselib.base.page.BasePageFragment

class MainActivity : BasePageActivity() {

    override fun getRootFragment(): BasePageFragment {
        return MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSwipeBackEnable(false)
    }
}
