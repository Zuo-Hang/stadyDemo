package com.example.demo.spring;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/10/27/17:48
 * @Description:
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FactoryBeanTest {
    public static void main(String[] args){
        String url = "src/main/resources/Bean.xml";
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(url);
        //ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext(url);
        Object school=  context.getBean("factoryBeanPojo");
        FactoryBeanPojo factoryBeanPojo= (FactoryBeanPojo) context.getBean("&factoryBeanPojo");
        System.out.println(school.getClass().getName());
        System.out.println(factoryBeanPojo.getClass().getName());
    }
}
