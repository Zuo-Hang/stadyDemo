package com.example.demo.junitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/10/17:40
 * @Description: 测试套件，把这些测试类嵌套在一起,一起进行测试
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculateTest.class,JunitFlowTest.class})
public class SuiteTest {
    /**
     * 写一个空的类：不包含任何方法
     * 更改测试运行期Suite.class
     * 将测试类作为数组传入到Suite.SuiteClass({})中
     */
}
