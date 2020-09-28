package com.example.demo.annotation;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/10/20:25
 * @Description:
 */
public class DemoTest1 {
    @MyTest
    public void test1(){
        System.out.println("test1执行了");
    }

    public void test2(){
        System.out.println("test2执行了");
    }

}
