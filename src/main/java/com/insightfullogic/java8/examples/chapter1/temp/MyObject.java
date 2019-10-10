package com.insightfullogic.java8.examples.chapter1.temp;

/**
 * @author by5388  on 2019/5/5.
 */

public class MyObject {
    private String mName;
    private ProtectedInterface mProtectedInterface;

    public ProtectedInterface getProtectedInterface() {
        if (mProtectedInterface == null) {
            mProtectedInterface = new InterfaceObject();
        }
        return mProtectedInterface;
    }

    private class InterfaceObject implements ProtectedInterface {
        @Override
        public String getName() {
            return mName;
        }

        @Override
        public void setName(String name) {
            mName = name;
        }
    }
}
