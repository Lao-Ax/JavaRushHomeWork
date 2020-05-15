package com.javarush.task.task04.task0424;

/* 
Три числа
Ввод с клавиатуры, сравнение чисел и вывод на экран — у студентов 4 уровня секретного центра JavaRush эти навыки
оттачиваются до автоматизма.
Давайте напишем программу, в которой пользователь вводит три числа с клавиатуры. Затем происходит сравнение, и если
мы находим число, которое отличается от двух других, выводим на экран его порядковый номер.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a != b && b != c && a != c ) {

        } else {

            if (a != b && a != c) {
                System.out.println("1");
            }

            if (b != a && b != c) {
                System.out.println("2");
            }

            if (c != b && c != a) {
                System.out.println("3");
            }
        }
    }
}
