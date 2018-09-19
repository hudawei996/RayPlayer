package com.thunder.player

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fungo.funplayer.controller.StandardPlayerController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mUrl = "http://221.228.226.5/14/z/w/y/y/zwyyobhyqvmwslabxyoaixvyubmekc/sh.yinyuetai.com/4599015ED06F94848EBF877EAAE13886.mp4"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = StandardPlayerController(this)

        controller.setTitle("这是点播")
        funPlayer.setController(controller)
        funPlayer.setUrl(mUrl)
        funPlayer.start()
    }
}
