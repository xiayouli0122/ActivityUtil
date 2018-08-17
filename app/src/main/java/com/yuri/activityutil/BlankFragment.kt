package com.yuri.activityutil

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.yuri.activity.lib.ActivityUtil


class BlankFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button1)
                .setOnClickListener {
                    ActivityUtil.with(context!!)
                            .activity(TestActivity::class.java)
                            .start()
                }

        view.findViewById<Button>(R.id.button2)
                .setOnClickListener {
                    ActivityUtil.with(context!!)
                            .activity(TestActivity::class.java)
                            .startResult()
                            .subscribe {
                                
                            }
                }
    }
}
