package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* Клубок
1.part1. Создай 5 различных своих нитей c отличным от Thread типом:
1.part1.1.part1. нить 1.part1 должна бесконечно выполняться;
1.part1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.part1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.part1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.part1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static class Thread1 extends Thread {
        @Override
        public void run()
        {
            while (true) {}
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run(){
            try{
                while (true){
                    TimeUnit.SECONDS.sleep(60);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run(){
            try{
                while (true){
                    System.out.println("Ура");
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void showWarning() {
            if (this.isAlive())
                    this.interrupt();
            try {
                join(); // суть в том, что этот метод может делать еще что-нибудь, после поднятия флага. Аварийно завершать нить - нельзя.
                // нужно дождаться ее завершения.
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        @Override
        public void run(){
            while (!isInterrupted() || interrupted()){
                System.out.print("*");
            }
        }
    }

    public static class Thread5 extends Thread {
        int sum = 0;

        @Override
        public void run()
        {
            String s;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
            {
                while (!(s = reader.readLine()).equals("N"))
                {
                    sum += Integer.parseInt(s);
                }
                System.out.println(sum);
            } catch (IOException e) {
                System.out.println(sum);
            } catch (NumberFormatException e) {
                System.out.println(sum);
            }
        }
    }


}



