package com.example.demo.observe_pattern;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/09/21/10:12
 * @Description:  抽象目标
 */
public abstract class Subject {
    protected ArrayList observers = new ArrayList<>();

    /**
     * 把观察者对象添加到观察者集合中
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 把观察者对象剔除到观察者集合中
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 声明抽象方法
     */
    public abstract void notifyObserver();
}
