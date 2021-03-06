package com.javarush.test.level14.lesson08.home07;

import java.util.ArrayList;
import java.util.List;

/* Клининговый центр
Клининговый центр
1.part1. Реализовать метод cleanAllApartaments.
Для каждого объекта из apartaments:
2. Для однокомнатных квартир (Apt1Room) вызвать метод clean1Room.
т.е. если объект типа Apt1Room, то вызвать у него метод clean1Room.
3. Для двухкомнатных квартир (Apt2Room) вызвать метод clean2Rooms
т.е. если объект типа Apt2Room, то вызвать у него метод clean2Rooms.
4. Для трехкомнатных квартир (Apt3Room) вызвать метод clean3Rooms
т.е. если объект типа Apt3Room, то вызвать у него метод clean3Rooms.
*/
public class Solution
{
    public static void main(String[] args)
    {
        List<Apartament> apartaments = new ArrayList<Apartament>();
        apartaments.add(new Apt1Room());
        apartaments.add(new Apt2Room());
        apartaments.add(new Apt3Room());

        cleanAllApartaments(apartaments);
    }

    public static void cleanAllApartaments(List<Apartament> apartaments)
    {
        for (Apartament a : apartaments){
            a.cleanRoom();
        }
    }

    static interface Apartament
    {
        void cleanRoom();
    }

    static class Apt1Room implements Apartament
    {
        public void cleanRoom()
        {
            System.out.println("1.part1 room is cleaned");
        }
    }

    static class Apt2Room implements Apartament
    {
        public void cleanRoom()
        {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class Apt3Room implements Apartament
    {
        public void cleanRoom()
        {
            System.out.println("3 rooms are cleaned");
        }
    }
}
