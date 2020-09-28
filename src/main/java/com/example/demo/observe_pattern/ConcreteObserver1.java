package com.example.demo.observe_pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/09/21/10:17
 * @Description: 具体观察者1号
 */
public class ConcreteObserver1 implements Observer {
    private String observerName;



    public ConcreteObserver1(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update() {
        System.out.println(observerName + "我要更新一下我的状态了......");
    }

}
