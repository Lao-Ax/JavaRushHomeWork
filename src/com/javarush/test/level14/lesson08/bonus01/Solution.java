package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //1.part1
        try { float i = 1 / 0;}
        catch (Exception e) { exceptions.add(e);}
        //2
        try { int[] i = new int[2]; i[5] = 3;}
        catch (Exception e) { exceptions.add(e);}
        //3
        try { String s = null; s.isEmpty();}
        catch (Exception e) { exceptions.add(e);}
        //4
        try { throw new EmptyStackException();}
        catch (Exception e) { exceptions.add(e);}
        //5
        try { throw new ClassNotFoundException();}
        catch (Exception e) { exceptions.add(e);}
        //6
        try { throw new CloneNotSupportedException();}
        catch (Exception e) { exceptions.add(e);}
        //7
        try { throw new NoSuchMethodException();}
        catch (Exception e) { exceptions.add(e);}
        //8
        try { throw new SecurityException();}
        catch (Exception e) { exceptions.add(e);}
        //9
        try { throw new StringIndexOutOfBoundsException();}
        catch (Exception e) { exceptions.add(e);}
        //10
        try { throw new NoSuchFieldException();}
        catch (Exception e) { exceptions.add(e);}
    }
}
