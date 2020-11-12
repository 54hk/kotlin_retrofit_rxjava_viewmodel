package com.hk.com_ans_student.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hk.com_ans_student.R
import com.hk.com_ans_student.base.BaseActivity
import com.hk.com_ans_student.utils.click
import com.hk.com_ans_student.utils.logE
import com.hk.com_ans_student.utils.startActivity
import com.hk.com_ans_student.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var homeViewModel: HomeViewModel;

    companion object {
        lateinit var activity: AppCompatActivity
        lateinit var context: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        activity = this
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        but_net.click {

            homeViewModel.loadJokeData()

        }

        homeViewModel.funcaiton.observe(this, Observer {
            logE("funcaiton  change")
        })
        homeViewModel.jokeData.observe(this, {
            logE("jokeData  change")
        })
        homeViewModel.xingData.observe(this, {
            logE("xingData  change")
        })

    }


}
//"createDate":"星期三 十一月 11 17:03:24 CST 2020","flag":0,"data":
//[{"beginDate":"19:00","actorId":"actorId","endDate":"20:00","name":"B","liveId":10003}],"message":"成功","failed":false}