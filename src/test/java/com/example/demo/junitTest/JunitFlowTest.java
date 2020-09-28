package com.example.demo.junitTest;

import org.junit.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/10/17:29
 * @Description:
 */
public class JunitFlowTest {
    @BeforeClass
    public static void setUpBeforeClass()throws Exception{
        System.out.println("beforeClass……");
    }
    @AfterClass
    public static void tearDownAfterClass()throws Exception{
        System.out.println("afterClass……");
    }
    @Before
    public void setUp()throws Exception{
        System.out.println("before……");
    }
    @After
    public void tearDown()throws Exception{
        System.out.println("after……");
    }
    @Test
    public void test1(){
        System.out.println("test1方法……");
    }
    @Test
    public void test2(){
        System.out.println("test2……");
    }

}
