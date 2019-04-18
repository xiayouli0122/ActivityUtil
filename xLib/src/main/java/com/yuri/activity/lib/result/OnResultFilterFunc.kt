package com.yuri.activity.lib.result

import android.app.Activity

import io.reactivex.functions.Predicate

class OnResultFilterFunc : Predicate<ActivityResultInfo> {
    override fun test(activityResultInfo: ActivityResultInfo): Boolean {
        return activityResultInfo.resultCode == Activity.RESULT_OK
    }
}
