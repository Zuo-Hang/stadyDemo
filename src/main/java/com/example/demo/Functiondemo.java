package com.example.demo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/03/17:29
 * @Description:
 */
public class Functiondemo {
    {
        Mapmap.map.put(1,this::m1);
        Mapmap.map.put(2,this::m2);
    }
    public void m1(Integer i,String s){
        System.out.println("m1");
    }

    public void m2(Integer i,String s){
        System.out.println("m2");
    }
}
