package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Alex on 20.05.2015 020.
 */
public class Keyboard implements CompItem
{
    @Override
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
}
