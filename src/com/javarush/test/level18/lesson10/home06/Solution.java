package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new FileReader(args[0]);
        Map<Integer, Integer> map = new TreeMap<>();

        int charCode;
        while ((charCode = reader.read()) != -1) {
            if (!map.containsKey(charCode)) {
                map.put(charCode, 1);
            } else {
                map.put(charCode, map.get(charCode) + 1);
            }
        }
        reader.close();

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int i = pair.getKey();
            char c = (char) i;
            int count = pair.getValue();
            System.out.println(c + " " + count);
        }
    }
}
