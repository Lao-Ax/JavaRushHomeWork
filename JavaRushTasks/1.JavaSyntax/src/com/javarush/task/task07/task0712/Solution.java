package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые

1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minStringValue = Integer.MAX_VALUE;
        int maxStringValue = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            String newItem = reader.readLine();
            list.add(newItem);
            if (minStringValue > newItem.length()) {
                minStringValue = newItem.length();
            }

            if (maxStringValue < newItem.length()) {
                maxStringValue = newItem.length();
            }
        }

        for (String s : list) {
            if (s.length() == maxStringValue || s.length() == minStringValue) {
                System.out.println(s);
                break;
            }
        }
    }
}
