package com.javarush.test.level08.lesson08.task01;

import java.util.Collections;
import java.util.HashSet;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        String[] words = new String[] {"л1", "л2", "л3", "л4", "л5", "л6", "л7", "л8", "л9", "л10", "л11",
                "л12", "л13", "л14", "л15", "л16", "л17", "л18", "л19", "л20"};
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, words);
        return set;
    }
}
