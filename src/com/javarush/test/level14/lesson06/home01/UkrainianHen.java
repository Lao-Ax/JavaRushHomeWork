package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alex on 18.05.2015 018.
 */
public class UkrainianHen extends Hen
{
    @Override
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

    @Override
    int getCountOfEggsPerMonth()
    {
        return 3;
    }
}
