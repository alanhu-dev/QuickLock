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
            .setMessage(R.string.accessibility_service_description)
            .setPositiveButton(android.R.string.ok) { _, _ -> lockScreen() }
            .setNegativeButton(android.R.string.cancel) { _, _ -> finish() }
            .setCancelable(false)
            .show()
    }

    private fun lockScreen() {
        ScreenLockService.start(this)
        finish()
    }
}