package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Alex on 20.05.2015 020.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "USD";
    }
}
