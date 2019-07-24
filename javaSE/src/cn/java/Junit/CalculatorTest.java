package cn.java.Junit;

import cn.java.domain.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int add = calculator.add(1, 2);
        Assert.assertEquals(3, add);
    }

    @Before
    public void init() {
        System.out.println("before...");
    }

    @After
    public void after () {
        System.out.println("after...");
    }
}
