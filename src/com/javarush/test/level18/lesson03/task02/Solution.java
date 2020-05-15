package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        int minByte = Byte.MAX_VALUE;
        FileInputStream inputStream = new FileInputStream(filename);

        while (inputStream.available() > 0) {
            int b = inputStream.read();
            if (b < minByte) {
                minByte = b;
            }
        }
        System.out.println(minByte);
        inputStream.close();
    }
}
