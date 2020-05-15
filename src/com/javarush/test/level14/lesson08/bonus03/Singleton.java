package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Alex on 22.05.2015 022.
 */
public class Singleton {

    private static Singleton singletonInstance;

    public static synchronized Singleton getInstance(){
        if (singletonInstance == null ) {
            singletonInstance = new Singleton();
		}
		return singletonInstance;
    }

    private Singleton(){}
}
