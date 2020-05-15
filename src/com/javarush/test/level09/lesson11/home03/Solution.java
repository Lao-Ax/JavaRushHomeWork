package com.javarush.test.level09.lesson11.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                list.add(Integer.parseInt(reader.readLine()));
            }
        } catch (NumberFormatException e) {
            printList(list);
        } catch (IOException e) {
            System.out.print(e.getClass());
        }
    }

    public static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.println(i);
        }
    }
}
