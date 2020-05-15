package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1.part1
Боб
3
Яблоко
2
0
Арбуз

Пример вывода:
Арбуз
3
Боб
2
Вишня
1.part1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        TreeMap<Integer, String> strings = new TreeMap<>();
        TreeMap<Integer, Integer> digits = new TreeMap<>();

        for (int i = 0; i < array.length; i++){
            if (isNumber(array[i])) {
                digits.put(i, Integer.parseInt(array[i]));
            } else {
                strings.put(i, array[i]);
            }
        }

        sortStrings(strings);
        sortDigits(digits);

        for (Map.Entry<Integer, String> mapElement : strings.entrySet()){
            array[mapElement.getKey()] = mapElement.getValue();
        }
        for (Map.Entry<Integer, Integer> mapElement : digits.entrySet()){
            array[mapElement.getKey()] = String.valueOf(mapElement.getValue());
        }
    }

    public static void sortStrings(TreeMap<Integer, String> strings){
        if (strings.size() == 0) return;
        int left = strings.firstKey();
        int right = strings.lastKey();

        do {
            //Сдвигаем к концу массива "тяжелые элементы"
            for (int i = left; i < right; i = strings.higherKey(i)) {
                if(isGreaterThen(strings.get(i), strings.get(strings.higherKey(i)))) { // меняем местами
                    String buff = strings.get(i);
                    strings.put(i, strings.get(strings.higherKey(i)));
                    strings.put(i+1, buff);
                }
            }
            right = strings.lowerKey(right); // уменьшаем правую границу

            //Сдвигаем к началу массива "легкие элементы"
            for (int i = right; i > left ; i = strings.lowerKey(i)) {
                if(isGreaterThen(strings.get(i-1), strings.get(i))) {
                    String buff = strings.get(i);
                    strings.put(i, strings.get(i-1));
                    strings.put(i-1, buff);
                }
            }
            left = strings.higherKey(left);
        } while (left <= right);
    }

    public static void sortDigits(TreeMap<Integer, Integer> digits){
        if (digits.size() == 0) return;
        int[] arrayInts = new int[digits.size()];
        int j = 0;
        for (Map.Entry<Integer, Integer> map_element : digits.entrySet()) {
            arrayInts[j] = map_element.getValue();
            j++;
        }

        sort(0, arrayInts.length - 1, arrayInts);

        j = 0;
        for (Map.Entry<Integer, Integer> map_element : digits.entrySet()) {
            map_element.setValue(arrayInts[j]);
            j++;
        }
    }

    public static void sort(int L, int R, int[] arr)
    {
        int i = L, j = R;							      // запоминаем левую и правую границы в переменные
        int x = arr[(L+R)/2];                             // выбираем первый элемент для соритровки "случайно"
        do{											      // сортировка имеет смысл, пока границы не сойдутся => условие i<j
            while (arr[i] > x)                            // ищем первый индекс элемента, который больше х, но левее него.
                i++;
            while (x > arr[j])                            // ищем первый индекс элемента, который меньше х, но правее него.
                j--;
            if (i <= j){							      // если они по разные стороны, то их надо поменять местами
                int buf = arr[i];
                arr[i] = arr[j];
                arr[j] = buf;
                i++;								      // и двигаем границы
                j--;
            }
        } while (i < j);
        if (L < j) sort(L, j, arr);             // делаем то же самое для половинок. В эти условия не зайдем, если
        if (i < R) sort(i, R, arr);			    // только если достигли границ диапазона.
    }


    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }

    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
