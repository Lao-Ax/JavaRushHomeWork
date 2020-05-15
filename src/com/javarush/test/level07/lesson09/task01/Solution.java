package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1.part1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int N = 20;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }

        ArrayList<Integer> list_3 = new ArrayList<>();
        ArrayList<Integer> list_2 = new ArrayList<>();

        int n = N;
        for (int i = 0; i < n;){
            boolean to_be_removed = false;
            int x = list.get(i);
            if (x % 3 == 0) {
                list_3.add(x);
                to_be_removed = true;
            }
            if (x % 2 == 0) {
                list_2.add(x);
                to_be_removed = true;
            }
            if (to_be_removed)
            {
                list.remove(i);
                n--;
                continue;
            }
            i++;
        }

        printList(list_3);
        printList(list_2);
        printList(list);
    }

    public static void printList(List<Integer> list) {
        for (Integer i : list){
            System.out.println(i);
        }
    }
}
