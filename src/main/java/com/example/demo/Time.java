package com.example.demo;

import java.util.Date;

import static java.lang.Long.valueOf;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/27/22:04
 * @Description: 时间戳判断超时示例
 */
public class Time {
    public static boolean overtimeCode(long firstTime, long lastTime, long overtime) {
        boolean flag = false;
        long diff = firstTime - lastTime;
        if (diff > overtime) {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        //标记的起始时间
        long generateTime = System.currentTimeMillis() ;
        //获取的是毫秒数
        //当前时间
        long currentTime = System.currentTimeMillis() / 1000;
        //有效时间10*60
        boolean valid = overtimeCode(generateTime,currentTime,10*60);
        System.out.println((System.currentTimeMillis() - generateTime) * 0.001);
    }
}
