package com.yuri.activity.lib.result

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class ResultObserver : Observer<ActivityResultInfo> {
    override fun onSubscribe(d: Disposable) {

    }

    override fun onError(e: Throwable) {

    }

    override fun onComplete() {

    }
}
