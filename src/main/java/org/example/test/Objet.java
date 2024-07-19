package org.example.test;

// classic singleton pattern
public class Objet {

    // Singleton 클래스의 하나뿐인 인스턴스를 저장하는 정적 변수
    private static Objet a;
    private static Objet b;

    private Objet() {}

    public static Objet getObjet() {
        // 아직 인스턴스가 생성되지 않았다면,
        // private으로 선언된 생성자(private Objet() {})를 사용해서 Singleton 객체를 만듦.
        // a에 그 객체 대입.
        // 이러면 인스턴스가 필요한 상황까지 인스턴스를 생성하지 않음.
        // => LazyInstantiation
        if (a == null) {
            a = new Objet();

        } else if (b == null) {
            // a가 있다면, b를 생성.
            b = new Objet();
            return b;
        }
        return a;
    }
}
