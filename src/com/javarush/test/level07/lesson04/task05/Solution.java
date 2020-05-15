package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1.part1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        byte N = 20;
        byte N2 =  (byte) (N/2);
        int[] list = new int[N];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (byte i = 0; i < N; i++){
            list[i] = Integer.parseInt(reader.readLine());
        }

        int[] list2 = new int[N2];
        int[] list3 = new int[N2];

        for (byte i = 0; i < list.length/2; i++){
            list2[i] = list[i];
        }

        for (byte i = 0; i < list.length/2; i++){
            list3[i] = list[i+N2];
        }

        for (int i : list3){
            System.out.println(i);
        }

    }
}
