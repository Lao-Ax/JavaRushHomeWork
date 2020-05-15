package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        // initiaizing
        A a = new A();
        B b = new B();
        C c = new C();
        // setting references
        a.setB(b);
        a.setC(c);
        b.setC(c);
        c.setA(a);
        c.setB(b);
        // serializing
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(a);
        oos.writeObject(b);
        oos.writeObject(c);
        oos.flush();
        oos.close();
        // deserializing
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        A a1 = (A) ois.readObject();
        B b1 = (B) ois.readObject();
        C c1 = (C) ois.readObject();
        // testing
        System.out.println("a==a1: " + (a == a1));
        System.out.println("b==b1: " + (b == b1));
        System.out.println("c==c1: " + (c == c1));
        System.out.println("a1.getB()==b1: " + (a1.getB() == b1));
        System.out.println("a1.getC()==c1: " + (a1.getC() == c1));
        System.out.println("b1.getC()==c1: " + (b1.getC() == c1));
        System.out.println("c1.getA()==a1: " + (c1.getA() == a1));
        System.out.println("c1.getB()==b1: " + (c1.getB() == b1));
    }

    private static class A implements Serializable {
        private C c;
        private B b;

        public void setC(C c) {
            this.c = c;
        }

        public void setB(B b) {
            this.b = b;
        }

        public C getC() {
            return c;
        }

        public B getB() {
            return b;
        }
    }

    private static class B implements Serializable {
        private C c;

        public void setC(C c) {
            this.c = c;
        }

        public C getC() {
            return c;
        }
    }

    private static class C implements Serializable {
        private A a;
        private B b;

        public void setA(A a) {
            this.a = a;
        }

        public void setB(B b) {
            this.b = b;
        }

        public B getB() {
            return b;
        }

        public A getA() {
            return a;
        }
    }
}
