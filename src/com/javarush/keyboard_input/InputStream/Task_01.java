package com.javarush.keyboard_input.InputStream;

/* Как захватить мир
Ввести с клавиатуры число и имя, вывести на экран строку:
«имя» захватит мир через «число» лет. Му-ха-ха!
Пример: Вася захватит мир через 8 лет. Му-ха-ха!

Последовательность вводимых данных имеет большое значение.
*/

        import java.io.BufferedInputStream;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;

public class Task_01
{
    static String name;
    static String years;
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
        name = reader.readLine();
        years = reader.readLine();

        String main_string = name + " захватит мир через " + years + " лет. Му-ха-ха!";
        System.out.println(main_string);
    }
}