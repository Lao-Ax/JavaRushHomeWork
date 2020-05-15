package com.javarush.Examples;

/**
 * Created by Alex on 23.10.2016 023.
 */
public class ThreadTest{

    public static void main(String[] args) throws InterruptedException
    {
        ThreadTest threadTest = new ThreadTest();
        Clock clock = threadTest.new Clock();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        Thread.sleep(10000);
        clock.cancel();
    }

    class Clock implements Runnable{
        private volatile boolean isCancel = false;

        public void cancel(){
            this.isCancel = true;
        }

        public void run(){
            while (!this.isCancel){
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Tik");
            }
        }
    }
}
