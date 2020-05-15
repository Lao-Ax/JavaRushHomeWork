package com.javarush.test.level14.lesson08.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* User, Looser, Coder and Proger
1.part1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "looser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1.part1. Создать соответствующий объект [см Person.java], например, для строки "user" нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1.part1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Looser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        Set<String> key_set = new HashSet<>();
        key_set.add("user");
        key_set.add("looser");
        key_set.add("coder");
        key_set.add("proger");

        String s;
        while (key_set.contains((s = reader.readLine()).toLowerCase()))
        {
            s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
            person = (Person) Class.forName("com.javarush.test.level14.lesson08.home03.Person$"+s).newInstance();
            doWork(person);
        }
    }

    public static void doWork(Person person)
    {
        if (person instanceof Person.User)
            ((Person.User) person).live();
        else if (person instanceof Person.Looser)
            ((Person.Looser) person).doNothing();
        else if (person instanceof Person.Coder)
                ((Person.Coder) person).coding();
        else ((Person.Proger) person).enjoy();
    }
}
