package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1.part1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        PrintWriter outputStream = null;

        try {
            outputStream = new PrintWriter(new FileWriter(filename));
            String data;
            while (!(data = reader.readLine()).equals("exit"))
                outputStream.println(data);
            outputStream.print("exit");
        } finally {
            outputStream.close();
        }

//        BufferedReader br = null;
//        try
//        {
//            br = new BufferedReader(new FileReader(filename));
//            String s;
//            while ((s =br.readLine()) != null) {
//                System.out.println(s);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            br.close();
//        }
    }
}
