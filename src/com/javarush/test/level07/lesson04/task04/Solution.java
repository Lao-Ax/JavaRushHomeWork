package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1.part1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        byte N = 10;
        int[] list = new int[N];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (byte i = 0; i < N; i++){
            list[i] = Integer.parseInt(reader.readLine());
        }

        int buff;
        for (int i = 0, mid = list.length >> 1, j = list.length-1; i < mid; i++, j--){
            buff = list[i];
            list[i] = list[j];
            list[j] = buff;
        }

        for (int i : list){
            System.out.println(i);
        }
    }
}
