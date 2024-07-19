package org.example.test;

public class Singleton {
    // volatile 키워드를 사용하면 멀티스레딩 환경에서도
    // uniqueInstance 변수가 Singleton 인스턴스로 초기화되는 과정이 올바르게 진행됨.
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized ((Singleton.class)) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
