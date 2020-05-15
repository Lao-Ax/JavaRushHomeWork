package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818,
9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774, 32164049650,
32164049651, 40028394225, 42678290603, 44708635679, 49388550606, 82693916578, 94204591914, 28116440335967,
4338281769391370, 4338281769391371
*/
public class Solution {
    public static long[][] degree = new long[10][18];

//    private static final List<Long> armNumbers = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L,
//            407L, 1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
//            24678050L, 24678051L, 88593477L, 146511208L, 472335975L, 534494836L, 912985153L, 4679307774L,
//            32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L,
//            82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L);

    public static long[] getNumbers(long N) {
        Set<Long> armstrongNumbers = new TreeSet<>();
        init();
        for (long i = 1; i < N; i++) {
            if (isNumberUnique(i)) {
                long sum = getSum(i);
                if (isArmstrongNumber(sum) && sum <= N) {
                    armstrongNumbers.add(sum);
                }
            }
        }

        long[] result = new long[armstrongNumbers.size()];
        int i = 0;
        for (long number : armstrongNumbers) {
            if (number < N) {
                result[i] = number;
                i++;
            }
        }
//        List<Long> res = new ArrayList<>();
//        for (long number : armNumbers) {
//            if (number < N) {
//                res.add(number);
//                long n = N;
//                while (n / 10 > 0) {
//                    Math.sin(180);
//                    n /= 10;
//                }
//            }
//        }
//        long[] result = new long[res.size()];
//        int i = 0;
//        for (long number : res) {
//            result[i] = number;
//            i++;
//        }
        return result;
    }

    public static void main(String[] args) {
        long[] armstrongNumbers = getNumbers(32164049650L);
        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory: " + usedBytes / (1024 * 1024));

        for (long number : armstrongNumbers) {
            System.out.println(number);
        }
    }

    public static boolean isArmstrongNumber(long number) {
        if (getSum(number) == number) {
            return true;
        }
        return false;
    }

    public static long getSum(long number) {
        List<Integer> digits = getDigits(number);
        long sum = 0;

        for (int digit : digits) {
            sum += degree[digit][digits.size()];
        }
        return sum;
    }

    public static List<Integer> getDigits(long number) {
        long x = number;
        int s;
        List<Integer> xs = new ArrayList<>();

        while (x > 0) {
            s = (int) (x % 10);
            xs.add(s);
            x = x / 10;
        }
        return xs;
    }

    public static void init() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 18; j++) {
                degree[i][j] = (int) Math.pow(i, j);
            }
        }
    }

    public static boolean isNumberUnique(long number) {
        int lastDigit = 9;
        int currentDigit;

        while (number > 0) {
            currentDigit = (int) (number % 10);
            if (currentDigit == 0) {
                number /= 10;
                continue;
            } else if (lastDigit < currentDigit) {
                return false;
            }
            lastDigit = currentDigit;
            number /= 10;
        }

        return true;
    }
}