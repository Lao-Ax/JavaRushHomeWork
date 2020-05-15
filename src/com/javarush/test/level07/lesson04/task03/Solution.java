package com.javarush.test.level07.lesson04.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 2 массива
1.part1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает с текущим индексом из массива чисел. Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String[] list = new String[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (byte i = 0; i < 10; i++){
            list[i] = reader.readLine();
        }

        short[] list_length_array = new short[10];
        for (short i = 0; i < list.length; i++){
            list_length_array[i] = (short) list[i].length();
        }

        for (short i : list_length_array){
            System.out.println(i);
        }
    }
}
