package com.hk.com_ans_student.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hk.com_ans_student.base.BaseObserver
import com.hk.com_ans_student.base.BaseResp
import com.hk.com_ans_student.bean.HomeBean
import com.hk.com_ans_student.bean.JokeBean
import com.hk.com_ans_student.bean.XingBean
import com.hk.com_ans_student.net.APiService
import com.hk.com_ans_student.net.RetrofitFactory
import com.hk.com_ans_student.utils.logE
import com.hk.com_ans_student.utils.requestBody
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HomeViewModel : ViewModel() {
    var funcaiton = MutableLiveData<HomeBean>()
    var jokeData = MutableLiveData<JokeBean>()
    var xingData = MutableLiveData<XingBean>()
    fun login() {

        var map = mutableMapOf("mobile" to "手机号没有提供", "password" to "0724")
        RetrofitFactory.instance.getService(APiService::class.java).login(requestBody(map))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseObserver<HomeBean>("") {
                override fun onSuccess(t: BaseResp<HomeBean>) {
                    logE("----请求成功------")
                    funcaiton.value = t.data
                }

                override fun onFailure(e: Throwable?, isNetWorkError: Boolean) {
                    logE("----请求failure------")
                }

            })
    }

    //    https://www.juhe.cn/box/index/id/95
    fun loadJokeData() {
        var map = mutableMapOf(
            "page" to "1",
            "pagesize" to "1",
            "key" to "cf50bcc6226de11a783e2bd7dd10fb2a"
        )

        RetrofitFactory.instance.getService(APiService::class.java).joke(map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseObserver<JokeBean>("") {
                override fun onSuccess(t: BaseResp<JokeBean>) {
                    logE("----请求成功------")
                    jokeData.value = t.data
                }

                override fun onFailure(e: Throwable?, isNetWorkError: Boolean) {
                    logE("----请求failure------")
                }

            })
    }

    fun getii() {
        var map = mutableMapOf(
            "consName" to "水瓶座",
            "type" to "tomorrow",
            "key" to "0708a82c056038737fd328bda2f8e7d6"
        )
        RetrofitFactory.instance.getService(APiService::class.java).xing(map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                object : BaseObserver<XingBean>("加载中...") {

                    override fun onSuccess(t: BaseResp<XingBean>) {
                        logE("----请求成功------")
                        xingData.value = t.data
                    }

                    override fun onFailure(e: Throwable?, isNetWorkError: Boolean) {
                        logE("----请求成功------")
                    }
                }
            )
    }
}