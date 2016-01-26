package com.trilink.androidlib.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by b508a on 2016/1/25.
 */
public class ActivityCollector {


    public static ActivityCollector instance = new ActivityCollector();
    private List<Activity> mLists = new ArrayList<Activity>();

    private ActivityCollector() {
    }

    public synchronized static ActivityCollector getInstance() {

        return instance;
    }

    /**
     * 往集合中添加一个Activity
     *
     * @param pActivity
     */
    public void addActivity(Activity pActivity) {
        if (pActivity != null) {
            mLists.add(pActivity);
        }
    }

    /**
     * 从集合中删除一个Activity
     *
     * @param pActivity 需要删除的Activity
     */
    public void removeActivity(Activity pActivity) {
        if (pActivity != null) {
            if (mLists.contains(pActivity)) {
                mLists.remove(pActivity);
                pActivity.finish();
                pActivity = null;
            }
        }
    }

    //从栈中进行删除集合顶得Activity
    public void popActivity() {
        Activity activity = mLists.get(mLists.size() - 1);
        removeActivity(activity);
    }

    public int getNum() {
        return mLists.size();
    }

    /**
     * 完全删除集合中
     */
    public void finishActivity() {
        if (mLists != null && mLists.size() >= 0) {
            for (Activity pActivity : mLists) {
                pActivity.finish();
                pActivity = null;
            }
        }
    }
}