package com.superyao.quicklock

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS
import android.view.accessibility.AccessibilityEvent

class ScreenLock : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent) {}

    override fun onInterrupt() {}

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        if (!performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN)) {
            val accessibilitySettings = Intent(ACTION_ACCESSIBILITY_SETTINGS)
                .addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            startActivity(accessibilitySettings)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ScreenLock::class.java)
            context.startService(intent)
        }
    }
}