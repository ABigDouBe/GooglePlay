package com.dwarf.googleplay.utils;

import android.content.Context;
import android.content.res.Resources;

import com.dwarf.googleplay.MyApplication;

/**
 * Created by qurongzhen on 2017/7/8.
 * 封装和UI相关的操作
 */

public class UIUtils {
    /**
     * 得到上下文
     */
    public static Context getContext(){
        return MyApplication.getContext();
    }

    /**
     * 得到Resource对象
     */
    public static Resources getResource(){
        return getContext().getResources();
    }

    /**
     * 得到String.xml文件中字符串的信息
     */
    public static String getString(int resId){
        return getResource().getString(resId);
    }

    /**
     * 得到String.xml文件中的字符串数组信息
     */
    public static String[] getStringArray(int resId){
        return getResource().getStringArray(resId);
    }

    /**
     * 得到Color.xml文件中颜色信息
     */
    public static int getColor(int resId){
        return getResource().getColor(resId);
    }

    /**
     * 得到应用程序包名
     */
    public static String getPackageName(){
        return getContext().getPackageName();
    }
}
