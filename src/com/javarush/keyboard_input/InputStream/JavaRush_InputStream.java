package com.javarush.keyboard_input.InputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 19.01.2015 019.
 */
public class JavaRush_InputStream
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите имя: ");
        String name = reader.readLine();

        System.out.print("Введите возраст: ");
        String sAge = reader.readLine();
        int age = Integer.parseInt(sAge);
    }
}
