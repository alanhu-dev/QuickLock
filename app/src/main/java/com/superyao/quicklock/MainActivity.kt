package com.superyao.quicklock

import android.app.Activity
import android.os.Bundle
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.superyao.quicklock.service.ScreenLockService

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (ScreenLockService.isEnabled(this)) {
            lockScreen()
            return
        }
        showGuide()
    }

    private fun showGuide() {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.app_name)
            .setMessage(R.string.accessibility_service_guide)
            .setPositiveButton(R.string.guide_agree) { _, _ -> lockScreen() }
            .setNegativeButton(R.string.guide_decline) { _, _ -> finish() }
            .setCancelable(false)
            .show()
    }

    private fun lockScreen() {
        ScreenLockService.start(this)
        finish()
    }
}