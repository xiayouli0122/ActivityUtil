package com.yuri.activity.lib

import android.app.Activity
import android.content.Context
import android.content.Intent

import com.yuri.activity.lib.result.ActivityOnResult
import com.yuri.activity.lib.result.ActivityResultInfo

import io.reactivex.Observable

class ActivityTarget internal constructor(private val mActivity: Activity) : Target {

    override val context: Context
        get() = mActivity

    override fun startActivity(intent: Intent) {
        mActivity.startActivity(intent)
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int): Observable<ActivityResultInfo> {
        return ActivityOnResult.with(mActivity).startForResult(intent, requestCode)
    }
}
