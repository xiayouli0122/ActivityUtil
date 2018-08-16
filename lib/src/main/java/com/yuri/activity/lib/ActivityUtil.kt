package com.yuri.activity.lib

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Activity启动封装
 * Created by Yuri on 2016/5/19.
 */
object ActivityUtil {

    fun with(activity: AppCompatActivity): DefaultRequest {
        return DefaultRequest(ActivityCompatTarget(activity))
    }

    fun with(activity: Activity): DefaultRequest {
        return DefaultRequest(ActivityTarget(activity))
    }

    fun with(context: Context): DefaultRequest {
        return DefaultRequest(ContextTarget(context))
    }

    fun with(fragment: android.app.Fragment): DefaultRequest {
        return DefaultRequest(FragmentTarget(fragment))
    }

    fun with(fragment: Fragment): DefaultRequest {
        return DefaultRequest(SupportFragmentTarget(fragment))
    }
}
