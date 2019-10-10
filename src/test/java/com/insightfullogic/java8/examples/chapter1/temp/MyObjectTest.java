package com.insightfullogic.java8.examples.chapter1.temp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author by5388  on 2019/5/5.
 */
public class MyObjectTest {

    private MyObject mSubject;

    @BeforeMethod
    public void setUp() {
        mSubject = new MyObject();
    }

    @Test
    public void testGetProtectedInterface() {
        ProtectedInterface protectedInterface = mSubject.getProtectedInterface();
        protectedInterface.setName("hangShen");
        System.out.println(protectedInterface.getName());

    }
}