package com.javarush.Examples;

/**
 * Created by Alex on 04.04.2015 004.
 */
public class OverLoadTest {

    public void method(int a) {}

    public String method(int a, int b) {return "";};

    private static void static_method(){}

    private void non_static_method(){
        static_method();
    }

    private static void static_method_2() {
        //non_static_method(); // can't do that
    }

}
