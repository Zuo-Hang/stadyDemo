package spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author zuo hang
 * @Date 2020/10/16 0016 20:39
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        programUseDefaultListableBeanFactory();
    }

    /**
     * 编程的方式使用DefaultListableBeanFactory
     */
    public static void programUseDefaultListableBeanFactory(){
        //创建IOC配置文件的抽象资源
        ClassPathResource resource = new ClassPathResource("bean.xml");
        //创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建读取器
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        //读入配置信息，具体解析过程由XmlBeanDefinitionReader来完成
        beanDefinitionReader.loadBeanDefinitions(resource);

    }
}
