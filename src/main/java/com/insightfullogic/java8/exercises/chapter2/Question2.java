package com.insightfullogic.java8.exercises.chapter2;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.function.Supplier;

import javax.swing.text.DateFormatter;

public class Question2 {

    public static ThreadLocal<DateFormatter> formatter
            = ThreadLocal.withInitial(()->new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy", Locale.US)) );
//    相同的月显示效果：如1月，默认的设备语音是美国的Ebnhlish
//            M:1
//            MM:01
//            MMM:Jan
//            MMMM:January
//            MMM...M:January

}
