package com.yuri.activity.lib

import android.app.Activity
import android.content.Context
import android.content.Intent

import com.yuri.activity.lib.result.ActivityOnResult
import com.yuri.activity.lib.result.ActivityResultInfo

import io.reactivex.Observable

class ContextTarget internal constructor(override val context: Context) : Target {

    override fun startActivity(intent: Intent) {
        context.startActivity(intent)
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int): Observable<ActivityResultInfo> {
        return if (context is Activity) {
            ActivityOnResult.with(context).startForResult(intent, requestCode)
        } else {
            Observable.empty()
        }
    }
}
