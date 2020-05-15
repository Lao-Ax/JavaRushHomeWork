package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(filename);
        Map<Integer, Integer> byteIntegerMap = new TreeMap<>();
        for (int i = 0; i < 255; i++){
            byteIntegerMap.put(i, 0);
        }

        while (inputStream.available() > 0) {
            int b = inputStream.read();
            byteIntegerMap.put(b, byteIntegerMap.get(b)+1);
        }
        inputStream.close();

        int maxRepeat = Byte.MIN_VALUE;
        int byteMaxRepeated = 0;
        for (Map.Entry<Integer, Integer> pair : byteIntegerMap.entrySet()) {
            if (pair.getValue() > maxRepeat) {
                maxRepeat = pair.getValue();
                byteMaxRepeated = pair.getKey();
            }
        }

        for (int i = 0; i < maxRepeat; i++){
            System.out.print(byteMaxRepeated + " ");
        }

    }
}
