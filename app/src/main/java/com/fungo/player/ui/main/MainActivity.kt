package com.fungo.player.ui.main

import android.os.Bundle
import com.fungo.baselib.base.page.BasePageActivity
import com.fungo.baselib.base.page.BasePageFragment

class MainActivity : BasePageActivity() {

    override fun getPageFragment(): BasePageFragment {
        return MainFragment()
    }

    override fun isSwipeBackEnable(): Boolean = false

}
