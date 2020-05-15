package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Alex on 06.06.2015 006.
 */
public class Earth implements Planet
{
    private Earth(){};
    private static Earth instance = new Earth();

    public static Earth getInstance(){
        if (instance == null) return new Earth();
        else return instance;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
