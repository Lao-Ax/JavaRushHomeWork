package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileNameOne = args[0];
        String fileNameTwo = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileNameOne));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileNameTwo));

        int wordCounter = 0;
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length() > 6) {
                    if (wordCounter > 0) {
                        fileWriter.write("," + word);
                    } else {
                        fileWriter.write(word);
                    }
                    wordCounter++;
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
