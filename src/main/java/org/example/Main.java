package org.example;

import org.example.test.ChocolateBoiler;
import org.example.test.Objet;

public class Main {
    public static void main(String[] args) {

        ChocolateBoiler cb1 = ChocolateBoiler.getInstance();
        ChocolateBoiler cb2 = ChocolateBoiler.getInstance();
        System.out.println("cb1: " + cb1);
        System.out.println("cb2: " + cb2);
        System.out.println("init=========================");
        System.out.println("cb1 isEmpty: " + cb1.isEmpty());
        System.out.println("cb2 isEmpty: " + cb2.isEmpty());
        System.out.println("cb1 boiled: " + cb1.isBoiled());
        System.out.println("cb2 boiled: " + cb2.isBoiled());

        System.out.println("fill=========================");
        System.out.println("cb1--------------------------");
        cb1.fill();
        System.out.println("cb1 isEmpty: " + cb1.isEmpty());
        System.out.println("cb2 isEmpty: " + cb2.isEmpty());
        System.out.println("cb1 boiled: " + cb1.isBoiled());
        System.out.println("cb2 boiled: " + cb2.isBoiled());
        System.out.println("cb2--------------------------");
        cb2.fill();
        System.out.println("cb1 isEmpty: " + cb1.isEmpty());
        System.out.println("cb2 isEmpty: " + cb2.isEmpty());
        System.out.println("cb1 boiled: " + cb1.isBoiled());
        System.out.println("cb2 boiled: " + cb2.isBoiled());

        System.out.println("boil=========================");
        System.out.println("cb1--------------------------");
        cb1.boil();
        System.out.println("cb1 isEmpty: " + cb1.isEmpty());
        System.out.println("cb2 isEmpty: " + cb2.isEmpty());
        System.out.println("cb1 boiled: " + cb1.isBoiled());
        System.out.println("cb2 boiled: " + cb2.isBoiled());
        System.out.println("cb2--------------------------");
        cb2.boil();
        System.out.println("cb1 isEmpty: " + cb1.isEmpty());
        System.out.println("cb2 isEmpty: " + cb2.isEmpty());
        System.out.println("cb1 boiled: " + cb1.isBoiled());
        System.out.println("cb2 boiled: " + cb2.isBoiled());

        System.out.println("drain========================");
        System.out.println("cb1--------------------------");
        cb1.drain();
        System.out.println("cb1 isEmpty: " + cb1.isEmpty());
        System.out.println("cb2 isEmpty: " + cb2.isEmpty());
        System.out.println("cb1 boiled: " + cb1.isBoiled());
        System.out.println("cb2 boiled: " + cb2.isBoiled());
        System.out.println("cb2--------------------------");
        cb2.drain();
        System.out.println("cb1 isEmpty: " + cb1.isEmpty());
        System.out.println("cb2 isEmpty: " + cb2.isEmpty());
        System.out.println("cb1 boiled: " + cb1.isBoiled());
        System.out.println("cb2 boiled: " + cb2.isBoiled());

        System.out.println("=============================");
    }
}