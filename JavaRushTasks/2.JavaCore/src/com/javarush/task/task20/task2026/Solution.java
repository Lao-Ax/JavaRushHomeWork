package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    count++;
                    int ii = i;
                    while (a[ii][j] != 0 && ii < a.length-1){
                        ii++;
                    }
                    int jj = j;
                    while (a[i][jj] != 0 && jj < a.length-1){
                        jj++;
                    }

                    for (int k = i; k <= ii; k++) {
                        for (int p = j; p <= jj; p++) {
                            a[k][p] = 0;
                        }
                    }
                }
            }
        }
        return count;
    }
}
