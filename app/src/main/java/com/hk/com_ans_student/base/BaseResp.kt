package com.hk.com_ans_student.base

data class BaseResp<T>(var code: Int = 0, var mgs: String, var data: T)