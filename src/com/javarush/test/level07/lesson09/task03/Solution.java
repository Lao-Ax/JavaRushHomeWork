package com.javarush.test.level07.lesson09.task03;

import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1.part1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "мама", "мыла", "раму", "целую", "вечность");

        int n = list.size();
        for (int i = 0; i < n; i++){
            list.add(n-i, "именно");
        }

        for (String s : list){
            System.out.print(s + "\n");
        }
    }
}
