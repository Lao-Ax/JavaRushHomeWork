package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1.part1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    Solution(Object o){}
    Solution(String o){}
    Solution(Number o){}

    protected Solution(int s){}
    protected Solution(double s){}
    protected Solution(short s){}

    public Solution(char c){}
    public Solution(byte b){}
    public Solution(boolean b){}

    private Solution(Integer p){};
    private Solution(Double p){};
    private Solution(Character p){};
}

