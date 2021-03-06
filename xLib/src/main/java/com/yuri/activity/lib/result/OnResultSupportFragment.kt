package com.yuri.activity.lib.result

import android.content.Intent
import android.util.SparseArray
import androidx.fragment.app.Fragment

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class OnResultSupportFragment : Fragment() {
    private val mSubjects: SparseArray<PublishSubject<ActivityResultInfo>> = SparseArray()

    fun startForResult(intent: Intent, requestCode: Int): Observable<ActivityResultInfo> {
        val subject = PublishSubject.create<ActivityResultInfo>()
        mSubjects.put(requestCode, subject)

        return subject.doOnSubscribe { startActivityForResult(intent, requestCode) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
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
