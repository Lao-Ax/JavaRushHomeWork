package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileNameOne));
        String s;
        int worldsCount = 0;
        while ((s = fileReader.readLine()) != null) {
            String[] words = s.split("\\W+");
            for (String word : words) {
                if (word.equals("world")) {
                    worldsCount++;
                }
            }
        }
        fileReader.close();

        System.out.println(worldsCount);
    }
}
