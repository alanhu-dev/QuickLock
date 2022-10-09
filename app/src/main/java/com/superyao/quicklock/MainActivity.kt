package com.superyao.quicklock

import android.app.Activity
import android.os.Bundle
import com.superyao.quicklock.service.ScreenLockService

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScreenLockService.start(this)
        finish()
    }
}