package com.example.demo.annotation;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/10/20:15
 * @Description:
 */
public class Test {
    @MyAnnotation(value = "123",name = "lisi")
    public static void test(){
        System.out.println("这是test");
    }

    /** 利用反射获取方法上的注解，并获取对应的值
      * 在实际应用中，拿到了方法上自定义的注解和属性值后，那就可以根据你具体的业务逻辑进行一些对应的操作 */
    public static void main(String[] args) throws Exception {
        //获取类的反射
        Class clazz = Class.forName("com.example.demo.annotation.Test");
        //获取方法的反射
        Method[] ms = clazz.getMethods();
        for (Method m : ms) {

            if(m.isAnnotationPresent(MyAnnotation.class)){
                String value = m.getAnnotation(MyAnnotation.class).value();
                String name = m.getAnnotation(MyAnnotation.class).name();
                System.out.println("value:"+value);
                System.out.println("name:"+name);
            }
        }
    }

}
