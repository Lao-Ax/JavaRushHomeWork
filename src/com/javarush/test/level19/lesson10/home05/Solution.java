package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileNameOne = args[0];
        String fileNameTwo = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileNameOne));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileNameTwo));

        while(fileReader.ready()){
            String line = fileReader.readLine();
            String[] words = line.split(" ");
            Pattern pattern = Pattern.compile("\\d");
            for (String word : words) {
                if (pattern.matcher(word).find()) {
                    fileWriter.write(word + " ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
