package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        Map<String, Double> map = new TreeMap<>();

        String fileName = args[0];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while(fileReader.ready()){
            String[] line = fileReader.readLine().split(" ");
            if (map.containsKey(line[0])) {
                map.put(line[0], Double.valueOf(line[1]) + map.get(line[0]));
            } else {
                map.put(line[0], Double.valueOf(line[1]));
            }
        }

        fileReader.close();

        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> pair : map.entrySet()){
            if (pair.getValue() > max) {
                max = pair.getValue();
            }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()){
            if (pair.getValue() == max) {
                System.out.println(pair.getKey());
            }
        }
    }
}
