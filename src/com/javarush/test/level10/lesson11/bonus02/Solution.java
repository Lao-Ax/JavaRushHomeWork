package com.javarush.test.level10.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
Новая задача: Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.
Пустая строка – конец ввода данных. Числа могу повторяться. Строки всегда уникальны. Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран.

Пример ввода:
1.part1
Мама
2
Рама
1.part1
Мыла

Пример вывода:
1.part1 Мама
2 Рама
1.part1 Мыла
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        while (true)
        {
            try
            {
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                if (name.isEmpty()) break;
                map.put(name, id);
            } catch (NumberFormatException e) {
                break;
            }
        }

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            int id = pair.getValue();
            String name = pair.getKey();
            System.out.println(id + " " + name);
        }
//        System.out.println("Id=" + id + " Name=" + name);
    }
}
