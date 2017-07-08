package com.dwarf.googleplay;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;

/**
 * Created by qurongzhen on 2017/7/8.
 */

public class MyApplication extends Application {
    private static Context mContext;

    /**
     * 程序的入口方法
     */
    @Override
    public void onCreate() {
        if (initMainProcess()) {
            //上下文
            mContext = getApplicationContext();


        }
        super.onCreate();
    }

    /**
     * 通用上下文
     */
    public static Context getContext(){
        return mContext;
    }

    /**
     * 判断当前是否是主进程
     */
    private boolean initMainProcess(){
        String packageName="";
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(this.getPackageName(), 0);
            if (packageInfo != null) {
                packageName = packageInfo.packageName;
            }
            //判断当前进程是否是主进程
            //得到进程id
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid==myPid) {
                    String processName = runningAppProcessInfo.processName;
                    if (processName.equalsIgnoreCase(packageName)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
