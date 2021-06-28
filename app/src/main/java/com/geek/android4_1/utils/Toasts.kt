package com.geek.android4_1.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast

class Toasts {
    companion object {
        fun showToast(context: Context, msg: String) {
            val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP, Gravity.CENTER, 180)
            toast.show()
        }
    }
}