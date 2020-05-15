package com.javarush.test.level07.lesson09.task04;

import java.util.ArrayList;
import java.util.Collections;

/* Буква «р» и буква «л»
1.part1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1.part1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("роза"); //0
        list.add("лира"); //1.part1
        list.add("лоза"); //2
        Collections.addAll(list, "лосины", "рогатый", "лермонтов");
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();
        for (String s : list){
            if (s.contains("л") && s.contains("р")) newList.add(s);
            else if (s.contains("л")) {
                newList.add(s);
                newList.add(s);
            } else if (!s.contains("р")) newList.add(s);
        }
        return newList;
    }
}