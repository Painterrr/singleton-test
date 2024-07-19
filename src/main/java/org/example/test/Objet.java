package org.example.test;

public class Objet {

    private Objet() {}

    static Objet a;
    static Objet b;

    public static Objet getObjet() {
        if (a == null) {
            a = new Objet();

        } else if (b == null) {
            b = new Objet();
            return b;
        }
        return a;
    }
}
