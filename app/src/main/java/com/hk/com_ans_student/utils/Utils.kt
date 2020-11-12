package com.hk.com_ans_student.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject

/**
 * POST请求体，将map转换成RequestBody
 * @param map 参数
 */
fun requestBody(map: Map<String, String>): RequestBody {

    var jsonObject = JSONObject()
    if (map.isNotEmpty())
        map.forEach {
            jsonObject.put(it.key, it.value)
        }
    return RequestBody.create("application/json".toMediaTypeOrNull(), jsonObject.toString())
}


//使用内联函数的泛型参数 reified 特性来实现
/**
 * 普通activity跳转
 *
 * @param bundle 参数
 */
inline fun <reified T : AppCompatActivity> Context.startActivity(bundle: Bundle?) {
    val intent = Intent(this, T::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    if (bundle != null) {
        intent.putExtra("budle", bundle)
    }
    startActivity(intent)
}
/**
 * 有回调的activity跳转
 * @receiver Context
 * @param activity AppCompatActivity
 * @param bundle Bundle? 传值使用
 * @param flag Int 回调
 */
inline fun <reified T : AppCompatActivity> Context.startActivityForResult(
    activity: AppCompatActivity,
    bundle: Bundle?,
    flag: Int
) {
    val intent = Intent(this, T::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    if (bundle != null) {
        intent.putExtra("budle", bundle)
    }
    activity.startActivityForResult(intent, flag)
}


/**
 * 按钮点击
 */
fun View.click(block: () -> Unit) {
    setOnClickListener {
        block()
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun logE(mgs: String) {
    if (MainUtil.IS_PRISH_LOG)
        Log.e(MainUtil.RETROFIT_LOGGER, "logE -> $mgs")
}