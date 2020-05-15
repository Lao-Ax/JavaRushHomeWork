package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileNameOne));
        BufferedWriter fileTwoWriter = new BufferedWriter(new FileWriter(fileNameTwo));

        String line;
        List<String> allDigits = new ArrayList<>();
        while ((line = fileReader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                try {
                    Integer.parseInt(word);
                    allDigits.add(word);
                } catch (NumberFormatException e) {}
            }
        }
        fileReader.close();

        for (String s : allDigits) {
            fileTwoWriter.write(s+" ");
        }
        fileTwoWriter.close();
    }
}
