package com.hk.com_ans_student.dialog

import com.hk.com_ans_student.base.BaseActivity
import com.kaopiz.kprogresshud.KProgressHUD

/**
 * 请求网络需要到加载框
 */
class ProgressHK {
    companion object{

        fun show():KProgressHUD{
            return KProgressHUD.create(BaseActivity.activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE) // SPIN_INDETERMINATE, PIE_DETERMINATE, ANNULAR_DETERMINATE, BAR_DETERMINATE
                .setCancellable(false)
                .setDimAmount(0.5f)
                .show()
        }

        /**
         * tip: 提示标题
         */
        fun show(tip:String):KProgressHUD{
            return KProgressHUD.create(BaseActivity.activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(tip)
                .setCancellable(false)
                .setDimAmount(0.5f)
                .show()
        }
    }

}