package com.example.demo.observe_pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/09/21/10:19
 * @Description: 测试类
 */
public class NotifyMain {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver1("观察者一号");
        Observer observer2 = new ConcreteObserver2("观察者二号");
        subject.attach( observer);
        subject.attach(observer2);
        subject.notifyObserver();
    }
}
