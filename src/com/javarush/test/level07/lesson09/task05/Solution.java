package com.javarush.test.level07.lesson09.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удвой слова
1.part1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Используя цикл for выведи результат на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int N = 10;
        for (int i = 0; i < N; i++) list.add(reader.readLine());

        ArrayList<String> result = doubleValues(list);

        for (String s : result) System.out.print(s + "\n");
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        int n = list.size();
        for (int i = 0; i < n; i++){
            list.add(n-i, list.get(n-i-1));
        }
        return list;
    }
}
