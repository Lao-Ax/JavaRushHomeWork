package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        sol.print(7);
        sol.print(new Integer(7));
    }

    private void print(int a){

    }
    private void print(Integer I){

    }
}
