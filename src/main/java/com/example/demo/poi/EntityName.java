package com.example.demo.poi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * @author zuo
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)//指定注解在运行时有效
public @interface EntityName {
	
	 /** 
     * 是否为序列号
     */  
    boolean id() default false;  
	/**
	 * 字段名称
	 */
	String column()default "";
	/** 
     * 排序字段
     */  
    Class clazz()default String.class;
}
