package com.superyao.quicklock

import android.service.quicksettings.TileService

class QSTileService : TileService() {
    override fun onClick() {
        super.onClick()
        ScreenLock.start(this)
    }
}