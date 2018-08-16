package com.yuri.activity.lib

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity

import com.yuri.activity.lib.result.ActivityOnResult
import com.yuri.activity.lib.result.ActivityResultInfo

import io.reactivex.Observable

class ActivityCompatTarget internal constructor(private val mActivity: AppCompatActivity) : Target {

    override val context: Context
        get() = mActivity

    override fun startActivity(intent: Intent) {
        mActivity.startActivity(intent)
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int): Observable<ActivityResultInfo> {
        return ActivityOnResult.with(mActivity).startForResult(intent, requestCode)
    }
}
