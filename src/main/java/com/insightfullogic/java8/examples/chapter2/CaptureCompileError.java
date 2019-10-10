package com.insightfullogic.java8.examples.chapter2;

import javax.swing.*;

public class CaptureCompileError {

    private JButton button;

    public void error() {
        String name = getUserName();
        name = formatUserName(name);
        // Uncommenting this line should cause a compile error:
        // TODO: 2019/10/10 lambda传递的，必须是一个不可变的对象
        // button.addActionListener(event -> System.out.println("hi " + name));
    }

    private String formatUserName(String name) {
        return name.toLowerCase();
    }

    private String getUserName() {
        return "RICHARD";
    }
}
