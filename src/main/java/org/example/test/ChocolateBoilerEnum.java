package org.example.test;

public enum ChocolateBoilerEnum {
    // 자동 스레드 안전성: 자바의 enum은 클래스 로딩 시점에 단 한 번만 인스턴스화됨. 별도의 동기화 코드가 필요없음.
    // 직렬화 안전성: enum을 사용하면 직렬화와 역직렬화 과정에서도 싱글톤 특성 유지. 별도의 readResolve 메서드를 구현할 필요없음.

    INSTANCE;

    private boolean empty;
    private boolean boiled;

    ChocolateBoilerEnum() {
        empty = true;
        boiled = false;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}