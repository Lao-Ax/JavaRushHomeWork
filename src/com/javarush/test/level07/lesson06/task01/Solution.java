package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1.part1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int N = 5;
        ArrayList<String> list = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++){
//            list.add(reader.readLine());
            list.add(i+"");
        }

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
