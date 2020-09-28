package com.example.demo.observe_pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/09/21/10:18
 * @Description: 具体观察者2号
 */
public class ConcreteObserver2 implements Observer{
    private String observerName;
    public ConcreteObserver2(String observerName) {
        this.observerName=observerName;
    }
    @Override
    public void update() {
        System.out.println(observerName+"我要更新一下我的状态了......");
    }

}
