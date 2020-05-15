package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        reader.close();

        BufferedReader fileOneReader = new BufferedReader(new FileReader(fileNameOne));
        BufferedWriter fileTwoWriter = new BufferedWriter(new FileWriter(fileNameTwo));

        String line;
        while ((line = fileOneReader.readLine()) != null) {
            String  newLine = line.replace(".", "!");
            fileTwoWriter.write(newLine + "\n");
        }
        fileOneReader.close();
        fileTwoWriter.close();
    }
}
