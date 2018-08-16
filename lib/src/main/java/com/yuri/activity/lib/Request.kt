package com.yuri.activity.lib

import android.os.Bundle
import android.os.Parcelable

import com.yuri.activity.lib.result.ActivityResultInfo

import io.reactivex.Observable
import java.io.Serializable

interface Request {
    fun activity(cls: Class<*>): Request
    fun withChar(name: String, value: Char): Request
    fun withCharArray(name: String, value: CharArray): Request
    fun withBoolean(name: String, value: Boolean): Request
    fun withBooleanArray(name: String, value: BooleanArray): Request
    fun withLong(name: String, value: Long): Request
    fun withLongArray(name: String, value: LongArray): Request
    fun withInt(name: String, value: Int): Request
    fun withIntArray(name: String, value: IntArray): Request
    fun withShort(name: String, value: Short): Request
    fun withShortArray(name: String, value: ShortArray): Request
    fun withDouble(name: String, value: Double): Request
    fun withDoubleArray(name: String, value: DoubleArray): Request
    fun withFloat(name: String, value: Float): Request
    fun withFloatArray(name: String, value: FloatArray): Request
    fun withByte(name: String, value: Byte): Request
    fun withByteArray(name: String, value: ByteArray): Request
    fun withString(name: String, value: String): Request
    fun withStringArray(name: String, value: Array<String>): Request
    fun withParcelable(name: String, value: Parcelable): Request
    fun withParcelableArray(name: String, value: Array<Parcelable>): Request
    fun withSerializable(name: String, value: Serializable): Request
    fun withIntArrayList(name: String, value: ArrayList<Int>): Request
    fun withStringArrayList(name: String, value: ArrayList<String>): Request
    fun withParcelableArrayList(name: String, value: ArrayList<Parcelable>): Request
    fun withBundle(bundle: Bundle): Request
    fun requestCode(requestCode: Int): Request
    fun start()
    fun startResult(): Observable<ActivityResultInfo>
}
