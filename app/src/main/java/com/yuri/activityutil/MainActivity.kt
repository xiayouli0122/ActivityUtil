package com.yuri.activityutil

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yuri.activity.lib.ActivityUtil
import com.yuri.activity.lib.result.OnResultFilterFunc
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            ActivityUtil.with(MainActivity@this)
                    .activity(TestActivity::class.java)
                    .start()
        }

        button2.setOnClickListener {
            ActivityUtil.with(MainActivity@this)
                    .activity(TestActivity::class.java)
                    .withString("text", "startActivityForResult")
                    .startResult()
                    .filter(OnResultFilterFunc())
                    .subscribe {
                        val data = it.data
                        val text = data?.getStringExtra("result")
                        textViewResult.text = text
                    }

        }

        button3.setOnClickListener {
            ActivityUtil.with(MainActivity@this)
                    .activity(TestActivity::class.java)
                    .withString("text", "startActivity")
                    .start()
        }

        button4.setOnClickListener {
            val list = arrayListOf<String>()
            list.add("Test")
            list.add("for")
            list.add("activity")
            val bundle = Bundle()
            bundle.putStringArrayList("list", list)
            ActivityUtil.with(MainActivity@this)
                    .activity(TestActivity::class.java)
                    .withString("text", "startActivityForResult bundle")
                    .withBundle(bundle)
                    .startResult()
                    .filter(OnResultFilterFunc())
                    .subscribe {
                        val data = it.data
                        val text = data?.getStringExtra("result")
                        textViewResult.text = text
                    }

        }
    }
}
