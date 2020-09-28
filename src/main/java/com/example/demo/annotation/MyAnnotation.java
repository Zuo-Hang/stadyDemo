package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/10/20:11
 * @Description: 自定义注解的学习
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    /**
     * 基本形式：类型 属性名称();
     *
     *         比如：String name();
     *
     * 特别注意：（1）属性值后边有一个括号！！！这个是和之前定义属性不一样的地方
     *
     *          2）注解的属性的类型只能是：基本类型、String、Class、枚举、注解类型及以上类型的一维数组。
     *
     * 定义注解属性的默认值：类型 属性名称() default 默认值;
     *
     *                   比如：String name() default "zhangsan";
     */
    String value() default "abc";

    String name() default "zhangsan";
    /**注解属性定义完以后，使用注解：@MyAnnotation(value = "123",name = "lisi")*/
}
