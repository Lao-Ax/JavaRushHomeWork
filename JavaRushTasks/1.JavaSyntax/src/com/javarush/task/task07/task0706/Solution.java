package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/* 
Улицы и дома

1. Создать массив на 15 целых чисел.
2. Ввести в него значения с клавиатуры.
3. Пускай индекс элемента массива является номером дома, а значение — число жителей, проживающих в доме.
Дома с нечетными номерами расположены на одной стороне улицы, с четными — на другой. Выяснить, на какой стороне улицы
 проживает больше жителей.
4. Вывеси на экран сообщение: «В домах с нечетными номерами проживает больше жителей.» или «В домах с четными
номерами проживает больше жителей.»

Примечание:
дом с порядковым номером 0 считать четным.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] houses = new int[15];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int evenPeople = 0;
        int oddPeople = 0;

        for (int i = 0; i < houses.length; i++) {
            houses[i] = Integer.valueOf(reader.readLine());
//            houses[i] = (int) (Math.random() * 10);
            if (i % 2 == 0) {
                evenPeople += houses[i];
            } else {
                oddPeople += houses[i];
            }
        }

        if (evenPeople > oddPeople) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
