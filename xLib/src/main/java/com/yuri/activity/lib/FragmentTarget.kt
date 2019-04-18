package com.yuri.activity.lib

import android.app.Fragment
import android.content.Context
import android.content.Intent

import com.yuri.activity.lib.result.ActivityOnResult
import com.yuri.activity.lib.result.ActivityResultInfo

import io.reactivex.Observable


class FragmentTarget internal constructor(private val mFragment: Fragment) : Target {

    override val context: Context
        get() = mFragment.activity

    override fun startActivity(intent: Intent) {
        mFragment.startActivity(intent)
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int): Observable<ActivityResultInfo> {
        return ActivityOnResult.with(mFragment).startForResult(intent, requestCode)
    }
}
