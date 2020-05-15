package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Alex on 06.06.2015 006.
 */
public class Moon implements Planet
{
    private Moon(){};
    private static Moon instance = new Moon();

    public static Moon getInstance(){
        if (instance == null) return new Moon();
        else return instance;
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName();
    }
}
