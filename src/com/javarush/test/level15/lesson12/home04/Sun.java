package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Alex on 06.06.2015 006.
 */
public class Sun implements Planet
{
    private Sun(){};
    private static Sun instance = new Sun();

    public static Sun getInstance(){
        if (instance == null) return new Sun();
        else return instance;
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName();
    }
}
