package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Alex on 09.06.2015 009.
 */
public class Plane implements Flyable
{
    private int pass_count;

    public Plane(int pass_count) {
        this.pass_count = pass_count;
    }
    @Override
    public void fly()
    {

    }
}
