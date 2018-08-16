package com.yuri.activityutil

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.yuri.xlog.XLog
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent?.let {
            val text = it.getStringExtra("text")
            XLog.d("text:$text")
            textView.text = text
            val bundle = it.extras

            bundle?.let {
                val list = bundle.getStringArrayList("list")
                list?.let {
                    textView.text = "${textView.text}\n${list[0]}\n${list[1]}\n${list[2]}"
                }
            }
        }

        val intent = Intent()
        intent.putExtra("result", "TestActivity Result")
        setResult(Activity.RESULT_OK, intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
