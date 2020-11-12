package com.hk.com_ans_student.utils;

import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

import com.hk.com_ans_student.base.BaseActivity;

public class ToastUtil {


    private static Toast toast;//实现不管我们触发多少次Toast调用，都只会持续一次Toast显示的时长

    /**
     * 短时间显示Toast【居下】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showShortToast(String msg) {
        if (BaseActivity.activity != null) {
            try {
                if (toast == null) {
                    toast = Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_SHORT);
                } else {
                    toast.setText(msg);
                }
                toast.show();
            } catch (Exception e) {
                //解决在子线程中调用Toast的异常情况处理
                Looper.prepare();
                Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

        }
    }

    /**
     * 短时间显示Toast【居中】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showShortToastCenter(String msg) {
        if (BaseActivity.activity != null) {
            try {
                if (toast == null) {
                    toast = Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                } else {
                    toast.setText(msg);
                }
                toast.show();
            } catch (Exception e) {
                //解决在子线程中调用Toast的异常情况处理
                Looper.prepare();
                Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_SHORT).show();;
                Looper.loop();
            }

        }
    }

    /**
     * 短时间显示Toast【居上】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showShortToastTop(String msg) {
        if (BaseActivity.activity != null) {
            try {
                if (toast == null) {
                    toast = Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                } else {
                    toast.setText(msg);
                }
                toast.show();
            } catch (Exception e) {
                Looper.prepare();
                Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_SHORT).show();;
                Looper.loop();
            }


        }
    }

    /**
     * 长时间显示Toast【居下】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showLongToast(String msg) {
        if (BaseActivity.activity != null) {
            try {


                if (toast == null) {
                    toast = Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_LONG);
                } else {
                    toast.setText(msg);
                }
                toast.show();
            } catch (Exception e) {
                Looper.prepare();
                Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_SHORT).show();;
                Looper.loop();
            }
        }
    }

    /**
     * 长时间显示Toast【居中】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showLongToastCenter(String msg) {
        if (BaseActivity.activity != null) {
            try {


                if (toast == null) {
                    toast = Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                } else {
                    toast.setText(msg);
                }
                toast.show();
            } catch (Exception e) {
                Looper.prepare();
                Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_SHORT).show();;
                Looper.loop();
            }
        }
    }

    /**
     * 长时间显示Toast【居上】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showLongToastTop(String msg) {
        if (BaseActivity.activity != null) {
            try {


                if (toast == null) {
                    toast = Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP, 0, 0);
                } else {
                    toast.setText(msg);
                }
                toast.show();
            } catch (Exception e) {
                Looper.prepare();
                Toast.makeText(BaseActivity.activity, msg, Toast.LENGTH_SHORT).show();;
                Looper.loop();
            }
        }
    }

}
