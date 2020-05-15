package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String englishAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        FileReader file = new FileReader(args[0]);

        int symbol;
        int countEnglishLetters = 0;
        while((symbol = file.read()) != -1) {
            if (englishAlphabet.indexOf((char) symbol) != -1) {
                countEnglishLetters++;
            }
        }
        file.close();

        System.out.print(countEnglishLetters);
    }
}
