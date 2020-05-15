package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1.part1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String s;
            while ((s =br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
