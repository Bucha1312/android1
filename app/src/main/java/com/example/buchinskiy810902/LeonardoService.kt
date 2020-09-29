package com.example.buchinskiy810902

import android.app.Service
import android.content.Intent
import android.os.IBinder

class LeonardoService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        sendBroadcast(
            Intent("end").putExtra(
                "value",
                leonardo(intent?.getIntExtra("input", 0) ?: 0)
            )
        )
        return super.onStartCommand(intent, flags, startId)
    }


    private fun leonardo(n: Int): Int {
        if (n == 0 || n == 1) return 1
        return leonardo(n - 1) + leonardo(n - 2) + 1
    }
}