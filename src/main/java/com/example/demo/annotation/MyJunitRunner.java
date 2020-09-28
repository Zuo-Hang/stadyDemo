package com.example.demo.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/10/20:25
 * @Description:
 */
public class MyJunitRunner {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        //取得类的字节码
        Class clazz = DemoTest1.class;
        //反射其中的成员，此处就是方法成员
        Method methods[] = clazz.getMethods();//得到DemoTest1中的所有公有的方法
        //看谁的上面有MyTest注解
        for(Method m:methods){
            //谁有，就执行谁
            boolean b = m.isAnnotationPresent(MyTest.class);
            System.out.println(b+"==="+m.getName());
            if(b){
                m.invoke(clazz.newInstance(), null);
            }
        }
    }

}
