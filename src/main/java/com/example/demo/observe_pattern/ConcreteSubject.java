package com.example.demo.observe_pattern;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/09/21/10:14
 * @Description: 具体目标
 */
public class ConcreteSubject extends Subject{
    /**
     * 实现通知的方法
     */
    @Override
    public void notifyObserver() {
        System.out.println("目标对象状态已变化......发送通知给观察者中");
        for(Object object:observers){
            ((Observer)object).update();
        }
    }}
