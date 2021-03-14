package com.example.activitytest

import android.app.Activity

object ActivityBox {
//    object里的属性会生成私有静态属性，还有公有静态变量的实例（还会私有构造函数）
    val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }
}