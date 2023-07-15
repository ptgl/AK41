package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    void tc01(){
        int[] arr = {9,9,9,9};
        Assert.assertEquals(Main.sumOne(arr), new int[]{1,0,0,0,0});
    }

    @Test (expectedExceptions = { IllegalArgumentException.class })
    void tc02(){
        int[] arr = {11,9,9,9};
        Main.sumOne(arr);
    }

    @Test (expectedExceptions = { IllegalArgumentException.class })
    void tc03(){
        int[] arr = {1,-9,9,9};
        Main.sumOne(arr);
    }

    @Test
    void tc04(){
        String s = "()";
        Assert.assertEquals(Main.isValidParentheses(s), true);
    }

    @Test
    void tc05(){
        String s = "(]";
        Assert.assertEquals(Main.isValidParentheses(s), false);
    }

    @Test
    void tc06(){
        String s = "(){}[]";
        Assert.assertEquals(Main.isValidParentheses(s), true);
    }

    @Test
    void tc07(){
        String s = "[({})]";
        Assert.assertEquals(Main.isValidParentheses(s), true);
    }
}
