package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filenameOne = reader.readLine();
        String filenameTwo = reader.readLine();
        reader.close();

        StringBuilder sb = new StringBuilder();
        String s;
        BufferedReader reader2 = new BufferedReader(new FileReader(filenameOne));
        while ((s = reader2.readLine()) != null) {
            sb.append(s);
        }
        reader2.close();

        String[] floats = sb.toString().split(" ");
        int[] ints = new int[floats.length];
        for (int i = 0; i < floats.length; i++) {
            ints[i] = Math.round(Float.parseFloat(floats[i]));
        }

        PrintWriter pw = new PrintWriter(new File(filenameTwo));
        for(int i : ints) {
            pw.write(i + " ");
        }
        pw.close();
    }
}
