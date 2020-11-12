package com.hk.com_ans_student.bean

data class JokeBean(
    val error_code: Int,
    val reason: String,
    val result: Result
)

data class Result(
    val dataList: List<DataList>
)

data class DataList(
    val content: String,
    val hashId: String,
    val unixtime: Int,
    val updatetime: String
)