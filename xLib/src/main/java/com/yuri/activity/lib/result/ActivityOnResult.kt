package com.yuri.activity.lib.result

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import io.reactivex.Observable

/**
 * 一种用于替换onActivityResult的方法，避免onActivityResult和startActivity分离不利于阅读
 */
class ActivityOnResult {

    private var mResultFragment: OnResultFragment? = null
    private var mResultSupportFragment: OnResultSupportFragment? = null

    private constructor(activity: AppCompatActivity) {
        mResultSupportFragment = getOnResultFragment(activity)
    }

    private constructor(fragment: Fragment) {
        mResultSupportFragment = getOnResultFragment(fragment)
    }

    private constructor(activity: Activity) {
        mResultFragment = getOnResultFragment(activity)
    }

    private constructor(fragment: android.app.Fragment) {
        mResultFragment = getOnResultFragment(fragment)
    }

    private fun getOnResultFragment(activity: AppCompatActivity): OnResultSupportFragment {
        var onResultFragment: OnResultSupportFragment? = findOnResultFragment(activity)
        if (onResultFragment == null) {
            onResultFragment = OnResultSupportFragment()
            val fragmentManager = activity.supportFragmentManager
            fragmentManager
                    .beginTransaction()
                    .add(onResultFragment, TAG)
                    .commitAllowingStateLoss()
            fragmentManager.executePendingTransactions()
        }
        return onResultFragment
    }

    private fun getOnResultFragment(activity: Activity): OnResultFragment {
        var onResultFragment: OnResultFragment? = findOnResultFragment(activity)
        if (onResultFragment == null) {
            onResultFragment = OnResultFragment()
            val fragmentManager = activity.fragmentManager
            fragmentManager
                    .beginTransaction()
                    .add(onResultFragment, TAG)
                    .commitAllowingStateLoss()
            fragmentManager.executePendingTransactions()
        }
        return onResultFragment
    }

    private fun getOnResultFragment(fragment: Fragment): OnResultSupportFragment {
        var onResultFragment: OnResultSupportFragment? = findOnResultFragment(fragment)
        if (onResultFragment == null) {
            onResultFragment = OnResultSupportFragment()
            val fragmentManager = fragment.childFragmentManager
            fragmentManager
                    .beginTransaction()
                    .add(onResultFragment, TAG)
                    .commitAllowingStateLoss()
            fragmentManager.executePendingTransactions()
        }
        return onResultFragment
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun getOnResultFragment(fragment: android.app.Fragment): OnResultFragment {
        var onResultFragment: OnResultFragment? = findOnResultFragment(fragment)
        if (onResultFragment == null) {
            onResultFragment = OnResultFragment()
            val fragmentManager = fragment.childFragmentManager
            fragmentManager
                    .beginTransaction()
                    .add(onResultFragment, TAG)
                    .commitAllowingStateLoss()
            fragmentManager.executePendingTransactions()
        }
        return onResultFragment
    }

    private fun findOnResultFragment(activity: AppCompatActivity): OnResultSupportFragment? {
        activity.supportFragmentManager.findFragmentByTag(TAG)?.let {
            return it as OnResultSupportFragment
        }
        return null
    }

    private fun findOnResultFragment(activity: Activity): OnResultFragment? {
        activity.fragmentManager.findFragmentByTag(TAG)?.let {
            return it as OnResultFragment
        }
        return null
    }

    private fun findOnResultFragment(fragment: Fragment): OnResultSupportFragment? {
        fragment.childFragmentManager.findFragmentByTag(TAG)?.let {
            return it as OnResultSupportFragment
        }
        return null
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun findOnResultFragment(fragment: android.app.Fragment): OnResultFragment? {
        fragment.childFragmentManager.findFragmentByTag(TAG)?.let {
            return it as OnResultFragment
        }
        return null
    }

    fun startForResult(clazz: Class<*>, requestCode: Int): Observable<ActivityResultInfo> {
        return startForResult(clazz, null, requestCode)
    }

    fun startForResult(clazz: Class<*>, bundle: Bundle?, requestCode: Int): Observable<ActivityResultInfo> {
        val context: Context = when {
            mResultFragment != null -> mResultFragment!!.activity
            mResultSupportFragment != null -> mResultSupportFragment!!.context
            else -> null
        } ?: return Observable.empty()

        val intent = Intent(context, clazz)
        bundle?.let {
            intent.putExtras(it)
        }
        return startForResult(intent, requestCode)
    }

    fun startForResult(intent: Intent, requestCode: Int): Observable<ActivityResultInfo> {
        if (mResultFragment != null) {
            return mResultFragment!!.startForResult(intent, requestCode)
        }

        mResultFragment?.let {
            return it.startForResult(intent, requestCode)
        }

        mResultSupportFragment?.let {
            return it.startForResult(intent, requestCode)
        }

        return Observable.empty()
    }

    companion object {

        private const val TAG = "ActivityOnResult"

        fun with(activity: Activity): ActivityOnResult {
            return ActivityOnResult(activity)
        }

        fun with(activity: AppCompatActivity): ActivityOnResult {
            return ActivityOnResult(activity)
        }

        fun with(fragment: Fragment): ActivityOnResult {
            return ActivityOnResult(fragment)
        }

        fun with(fragment: android.app.Fragment): ActivityOnResult {
            return ActivityOnResult(fragment)
        }
    }
}
