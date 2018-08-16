package com.yuri.activity.lib.result

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.util.SparseArray

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class OnResultFragment : Fragment() {

    private val mSubjects: SparseArray<PublishSubject<ActivityResultInfo>> = SparseArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    fun startForResult(intent: Intent, requestCode: Int): Observable<ActivityResultInfo> {
        val subject = PublishSubject.create<ActivityResultInfo>()
        mSubjects.put(requestCode, subject)

        return subject.doOnSubscribe { startActivityForResult(intent, requestCode) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        //rxjava方式的处理
        val subject = mSubjects.get(requestCode)
        if (subject != null) {
            subject.onNext(ActivityResultInfo(requestCode, resultCode, data))
            subject.onComplete()
        }
        mSubjects.remove(requestCode)
    }
}
