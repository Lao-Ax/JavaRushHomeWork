package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(filename);
        int[] byteArray = new int[256];

        while (inputStream.available() > 0) {
            int b = inputStream.read();
            byteArray[b]++;
        }

        int minRepeated = Byte.MAX_VALUE;
        for (int i = 0; i < byteArray.length; i++)
        {
            if (byteArray[i] > 0 && byteArray[i] < minRepeated)
            {
                minRepeated = byteArray[i];
            }
        }

        for (int i = 0; i < byteArray.length; i++){
            if (byteArray[i] == minRepeated) {
                System.out.print(i + " ");
            }
        }
    }
}
