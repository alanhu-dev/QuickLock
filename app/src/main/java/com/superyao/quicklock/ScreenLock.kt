package com.superyao.quicklock

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast

class ScreenLock : AccessibilityService() {

    companion object {
        fun start(context: Context) = context.startService(
            Intent(context, ScreenLock::class.java)
        )
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {}

    override fun onInterrupt() {}

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        try {
            if (!performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN)) {
                // failed, open the accessibility settings
                startActivity(
                    Intent(ACTION_ACCESSIBILITY_SETTINGS).apply {
                        addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
                    }
                )
            }
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "${getString(R.string.exception)}\n(${e.message})",
                Toast.LENGTH_LONG
            ).show()
        }
        return super.onStartCommand(intent, flags, startId)
    }
}