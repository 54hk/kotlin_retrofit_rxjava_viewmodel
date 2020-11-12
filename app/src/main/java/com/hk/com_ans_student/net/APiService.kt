package com.hk.com_ans_student.net

import com.hk.com_ans_student.base.BaseResp
import com.hk.com_ans_student.bean.HomeBean
import com.hk.com_ans_student.bean.JokeBean
import com.hk.com_ans_student.bean.XingBean
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

interface APiService {
    //爱能人登陆接口

    @POST(ApiAddress.LOGIN_URL)
    @Headers("Content-type:application/json; charset=utf-8")
    fun login(@Body info: RequestBody): Observable<BaseResp<HomeBean>>

    //  笑话大全
    @GET(ApiAddress.JOKE_URL)
    fun joke(@QueryMap map: Map<String, String>): Observable<BaseResp<JokeBean>>

    //星座
    @GET(ApiAddress.XING_URL)
    fun xing(@QueryMap map: Map<String, String>): Observable<BaseResp<XingBean>>
}