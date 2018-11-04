package com.fungo.player.ui.main

import com.fungo.baseuilib.activity.BaseContentActivity
import com.fungo.baseuilib.fragment.BaseFragment

class MainActivity : BaseContentActivity() {
    override fun getContentFragment(): BaseFragment = MainFragment()
}
