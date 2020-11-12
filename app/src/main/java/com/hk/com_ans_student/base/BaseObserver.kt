package com.hk.com_ans_student.base

import android.accounts.NetworkErrorException
import com.hk.com_ans_student.dialog.ProgressHK
import com.kaopiz.kprogresshud.KProgressHUD
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.net.ConnectException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

abstract class BaseObserver<T> : Observer<BaseResp<T>> {
    private var kProgressHUD: KProgressHUD
    private var labelText: String

    constructor(text: String) {
        this.labelText = text
        kProgressHUD = ProgressHK.show()
    }

    //  开始
    override fun onSubscribe(d: Disposable) {}

    //  获取数据
    override fun onNext(t: BaseResp<T>) {
        try {
            onSuccess(t)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //失败
    override fun onError(e: Throwable) {
        onRequestEnd()
        try {
            if (e is ConnectException
                || e is TimeoutException
                || e is NetworkErrorException
                || e is UnknownHostException
            ) {
                onFailure(e, true) //网络错误
            } else {
                onFailure(e, false)
            }
        } catch (e1: Exception) {
            e1.printStackTrace()
        }
    }

    //结束
    override fun onComplete() {
        onRequestEnd() //请求结束
    }

    //返回
    @Throws(Exception::class)
    protected abstract fun onSuccess(t: BaseResp<T>)

    /**
     * 返回失败
     *
     * @param e
     * @param isNetWorkError 是否是网络错误
     * @throws Exception
     */
    @Throws(Exception::class)
    protected abstract fun onFailure(e: Throwable?, isNetWorkError: Boolean)

    private fun onRequestStart() {
        kProgressHUD?.setLabel(labelText)
    }

    private fun onRequestEnd() {
        kProgressHUD?.dismiss()
    }

}