package com.fungo.player.app

import com.fungo.baselib.app.BaseApplication
import com.fungo.imagego.glide.GlideImageStrategy
import com.fungo.imagego.strategy.ImageGoEngine

/**
 * @author Pinger
 * @since 2018/9/20 下午12:33
 */
class PlayerApplication : BaseApplication() {

    override fun getCurrentEnvModel(): Int {
        return 3
    }

    override fun initSDK() {
        ImageGoEngine.setImageStrategy(GlideImageStrategy())
    }

    override fun isCanPrintLog(): Boolean = true

    override fun isCanSwitchEnv(): Boolean = true
}