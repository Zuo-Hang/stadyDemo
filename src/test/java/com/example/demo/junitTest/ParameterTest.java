package com.example.demo.junitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/10/17:47
 * @Description:
 */
@RunWith(Parameterized.class)
public class ParameterTest {
    int expected=0;
    int input1=0;
    int input2=0;

    @Parameterized.Parameters
    public static Collection<Object[]> t(){
        return Arrays.asList(new Object[][]{
                {3,1,2},
                {4,2,2}
        });
    }
    public ParameterTest(int expected, int input1, int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }
    //public ParameterTest(){}
    @Test
    public void testAdd(){
        assertEquals(expected,new Calculate().add(input1,input2));
    }
}
