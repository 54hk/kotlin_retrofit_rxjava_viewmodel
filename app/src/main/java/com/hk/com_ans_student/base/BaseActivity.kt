package com.hk.com_ans_student.base

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hk.com_ans_student.R
import com.hk.com_ans_student.utils.ToastUtil

class BaseActivity : AppCompatActivity() {

    companion object {
        fun getIntance(context: Context, name: String?): Unit {
            val intent = Intent(context, BaseActivity::class.java)
            intent.putExtra("name", name)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        ToastUtil.showLongToast(intent.extras?.getString("name"))
    }
}
