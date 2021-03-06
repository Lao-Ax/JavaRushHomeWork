package com.javarush.test.level18.lesson03.task01;

import java.io.*;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        int maxByte = 0;
        FileInputStream inputStream = new FileInputStream(filename);

        while (inputStream.available() > 0) {
            int b = inputStream.read();
            if (b > maxByte) {
                maxByte = b;
            }
        }
        System.out.println(maxByte);
        inputStream.close();
    }
}
