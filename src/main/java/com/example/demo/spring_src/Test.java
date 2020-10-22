package com.example.demo.spring_src;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/10/16/10:36
 * @Description:
 */
public class Test{
    public static void main(String[] args) {
        System.out.println("begin");
        tast2();
    }

    public static void tast() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(Appconfig.class);
        ac.refresh();
    }

    /**
     * 自定义bean工厂的后置处理器 tast
     */
    public static void tast2() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(Appconfig.class);
        ac.refresh();
        //正常打印
        System.out.println(ac.getBean(Y.class));
        //正常打印
        System.out.println(ac.getBean(Z.class));
        //异常打印
        //虽然X加了注解，但是被偷梁换柱了，故而异常
        System.out.println(ac.getBean(X.class));
    }

}

