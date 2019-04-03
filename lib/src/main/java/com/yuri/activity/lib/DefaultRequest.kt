package com.yuri.activity.lib

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable

import com.yuri.activity.lib.result.ActivityResultInfo

import io.reactivex.Observable
import java.io.Serializable

class DefaultRequest internal constructor(private val mTarget: Target) : Request {
    private lateinit var mIntent: Intent
    private var mRequestCode = 0

    override fun activity(cls: Class<*>): Request {
        mIntent = Intent()
        mIntent.setClass(mTarget.context, cls)
        return this
    }

    override fun withIntent(intent: Intent): Request {
        mIntent = intent
        return this
    }

    override fun withString(name: String, value: String): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withInt(name: String, value: Int): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withLong(name: String, value: Long): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withBoolean(name: String, value: Boolean): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withBundle(bundle: Bundle): Request {
        mIntent.putExtras(bundle)
        return this
    }

    override fun withChar(name: String, value: Char): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withCharArray(name: String, value: CharArray): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withBooleanArray(name: String, value: BooleanArray): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withLongArray(name: String, value: LongArray): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withIntArray(name: String, value: IntArray): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withShort(name: String, value: Short): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withShortArray(name: String, value: ShortArray): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withDouble(name: String, value: Double): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withDoubleArray(name: String, value: DoubleArray): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withFloat(name: String, value: Float): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withFloatArray(name: String, value: FloatArray): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withByte(name: String, value: Byte): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withByteArray(name: String, value: ByteArray): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withStringArray(name: String, value: Array<String>): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withParcelable(name: String, value: Parcelable): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withParcelableArray(name: String, value: Array<Parcelable>): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withSerializable(name: String, value: Serializable): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withIntArrayList(name: String, value: ArrayList<Int>): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withStringArrayList(name: String, value: ArrayList<String>): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun withParcelableArrayList(name: String, value: ArrayList<Parcelable>): Request {
        mIntent.putExtra(name, value)
        return this
    }

    override fun addFlags(flags: Int): Request {
        mIntent.addFlags(flags)
        return this
    }

    override fun setFlags(flags: Int): Request {
        mIntent.flags = flags
        return this
    }

    override fun setData(uri: Uri): Request {
        mIntent.data = uri
        return this
    }

    override fun setDataAndType(uri: Uri, type: String): Request {
        mIntent.setDataAndType(uri, type)
        return this
    }

    override fun setAction(action: String): Request {
        mIntent.action = action
        return this
    }

    override fun requestCode(requestCode: Int): Request {
        mRequestCode = requestCode
        return this
    }

    override fun start() {
        mTarget.startActivity(mIntent)
    }

    override fun startResult(): Observable<ActivityResultInfo> {
        return mTarget.startActivityForResult(mIntent, mRequestCode)
    }

}
