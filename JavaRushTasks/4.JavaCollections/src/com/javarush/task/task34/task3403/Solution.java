package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии

Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекурсивный метод для вычисления простых множителей.
Не создавай в классе Solution дополнительные поля.

Пример:
132

Вывод на консоль:
2 2 3 11


Требования:
1. В классе Solution не должны быть созданы дополнительные поля.
2. Метод recursion должен выводить на экран все простые множители числа полученного в качестве
параметра (пример в условии).
3. Метод recursion не должен быть статическим.
4. Метод recursion должен быть рекурсивным.
*/
public class Solution {
    public void recursion(int n) {
        int[] simple = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
                71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151,
                157, 163, 167, 173, 179, 181, 191, 193, 197, 199};
        if (n <= 1) {
            return;
        }

        int i = 0;
        while (n % simple[i] != 0) {
            i++;
        }
        System.out.print(simple[i] + " ");
        recursion(n / simple[i]);
    }

//    public static void main(String[] args) {
//        new Solution().recursion(112);
//    }
}