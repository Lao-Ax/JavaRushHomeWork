package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while(fileReader.ready()){
            String line = fileReader.readLine();
            PEOPLE.add(parseRow(line));
        }
        fileReader.close();
    }

    private static Person parseRow(String line) {
        String[] words = line.split(" ");
        String name = "";
        String stringDate = "";
        for (String word : words) {
            try {
                Integer.parseInt(word);
                if (word.length() < 2) {
                    word = "0" + word;
                }
                stringDate = stringDate + word;
            }
            catch (NumberFormatException e) {
                name = name + word + " ";
            }
        }
        name = name.trim();

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        Date date = null;
        try{
            date = sdf.parse(stringDate);
        }catch (ParseException e){
        }

        return new Person(name, date);
    }
}
