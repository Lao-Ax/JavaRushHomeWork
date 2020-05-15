package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Alex on 09.06.2015 009.
 */
public abstract class DrinkMaker{

    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
