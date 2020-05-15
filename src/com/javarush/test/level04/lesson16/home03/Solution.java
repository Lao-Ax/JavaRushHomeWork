package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1.part1, вывести на экран сумму и завершить программу.  -1.part1 должно учитываться в сумме.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int summ = Integer.parseInt(s);
        while (!s.equals("-1.part1")){
            s = reader.readLine();
            summ += Integer.parseInt(s);
        }
        System.out.print(summ);
    }
}
