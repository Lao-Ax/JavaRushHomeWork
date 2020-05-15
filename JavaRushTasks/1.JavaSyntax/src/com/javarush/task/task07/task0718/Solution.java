package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность

1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран номер первого элемента, нарушающего такую упорядоченность.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int index = -1;
        int lastLength;

        list.add(reader.readLine());

        for (int i = 1; i < 10; i++) {
            String newItem = reader.readLine();
            lastLength = list.get(i-1).length();
            if (newItem.length() < lastLength) {
                index = i;
                break;
            }
            list.add(newItem);
        }
        if (index != -1) {
            System.out.println(index);
        }
    }
}

