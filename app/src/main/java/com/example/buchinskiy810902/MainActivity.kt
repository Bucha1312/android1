package com.example.buchinskiy810902

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val broadcastReceiver:BroadcastReceiver=object :BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            if(intent.action=="end"){
                var result=intent.getIntExtra("value",0)
                textV.text=result.toString()
                Log.d("BuchinskiyOA", result.toString())
            }
        }
    }
         private var recreationCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(broadcastReceiver, IntentFilter("end"))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("recreate_k", recreationCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        recreationCount=savedInstanceState.getInt("recreate_k") +1

       // textV.text=recreationCount.toString()
        Log.w("BuchinskiyOA", recreationCount.toString())
        startService(Intent(this,LeonardoService::class.java).putExtra("input",recreationCount))
    }
}
