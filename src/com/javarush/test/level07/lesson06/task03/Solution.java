package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1.part1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int N = 100000;
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long timeout= System.currentTimeMillis();

        for (int i = 0; i < N; i++){
            list.add(i+"");
        }

        String buff;
        for (int i = 0; i < list.size()/2; i++){
            buff = list.get(i);
            list.set(i, list.get(list.size()-1-i));
            list.set(list.size()-1-i, buff);
        }

        System.out.println("Время работы программы: " + (System.currentTimeMillis() - timeout));

//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
    }
}
