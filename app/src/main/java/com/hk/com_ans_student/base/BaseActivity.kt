package com.hk.com_ans_student.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hk.com_ans_student.R.layout.activity_base
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        lateinit var activity: AppCompatActivity
    }
    private lateinit var view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_base)
        activity = this
        view = LayoutInflater.from(this).inflate(setLayoutId(), null)
        fl_base_content.addView(view)
        initView()
        initData()
        wingetListener()
        onObserve()
    }

    /**
     * 设置布局
     * @return Int
     */
    abstract fun setLayoutId(): Int

    /**
     * 初始化布局
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化监听
     */
    abstract fun wingetListener()

   open fun onObserve() {}
}
