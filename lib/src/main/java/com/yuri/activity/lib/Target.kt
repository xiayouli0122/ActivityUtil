package com.yuri.activity.lib

import android.content.Context
import android.content.Intent

import com.yuri.activity.lib.result.ActivityResultInfo

import io.reactivex.Observable

interface Target {
    val context: Context
    fun startActivity(intent: Intent)
    fun startActivityForResult(intent: Intent, requestCode: Int): Observable<ActivityResultInfo>
}
