package com.superyao.quicklock.service

import android.service.quicksettings.TileService

class ScreenLockTileService : TileService() {
    override fun onClick() {
        super.onClick()
        ScreenLockService.start(this)
    }
}