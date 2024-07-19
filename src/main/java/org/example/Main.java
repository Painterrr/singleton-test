package org.example;

import org.example.test.Objet;

public class Main {
    public static void main(String[] args) {

        Objet a = Objet.getObjet();
        Objet b = Objet.getObjet();
        Objet c = Objet.getObjet();
        Objet d = Objet.getObjet();

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
    }
}