package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1.part1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();

        List<Integer> list = readFile(path);
//        list.sort(Comparator.<Integer>naturalOrder());
        quickSort(0, list.size()-1, list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static List<Integer> readFile(String filePath) {
        List<Integer> list = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String s;
            while ((s = br.readLine()) != null) {
                int i = Integer.parseInt(s);
                if (i % 2 == 0) list.add(i);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e)
        {
            System.out.println(e.getMessage());
        }
        if (list.size() == 0) {
            System.out.println("Something is bad. There is no int value.");
            return null;
        }
        return list;
    }

    private static void quickSort(int L, int R, List<Integer> list) throws NullPointerException {
        if (list.size() == 0) throw new NullPointerException();
        int i = L, j = R;							      // запоминаем левую и правую границы в переменные
        int x = list.get((L+R)/2);                             // выбираем первый элемент для соритровки "случайно"
        do{											      // сортировка имеет смысл, пока границы не сойдутся => условие i<j
            while (list.get(i) < x)                            // ищем первый индекс элемента, который больше х, но левее него.
                i++;
            while (x < list.get(j))                            // ищем первый индекс элемента, который меньше х, но правее него.
                j--;
            if (i <= j){							      // если они по разные стороны, то их надо поменять местами
                int buf = list.get(i);
                list.set(i, list.get(j));
                list.set(j, buf);
                i++;								      // и двигаем границы
                j--;
            }
        } while (i < j);
        if (L < j) quickSort(L, j, list);             // делаем то же самое для половинок. В эти условия не зайдем, если
        if (i < R) quickSort(i, R, list);			 // только если достигли границ диапазона.
    }
}
