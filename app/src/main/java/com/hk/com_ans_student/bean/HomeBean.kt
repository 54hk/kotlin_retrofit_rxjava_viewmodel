package com.hk.com_ans_student.bean

data class HomeBean(
    val createDate: String,
    val `data`: List<Data>,
    val failed: Boolean,
    val flag: Int,
    val message: String
)

data class Data(
    val actorId: String,
    val beginDate: String,
    val endDate: String,
    val liveId: Int,
    val name: String
)